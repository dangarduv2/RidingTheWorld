import React, { Component } from "react";
import { ValidationMessage, ErrorMessage, Esperando, PaginacionCmd as Paginacion } from '../biblioteca/comunes.js';
import { titleCase } from '../biblioteca/formateadores.js';




export class PeliculasMnt extends Component {
    constructor(props) {
        super(props);
        this.state = {
            modo: "list",
            listado: null,
            elemento: null,
            error: null,
            loading: true,
            pagina: 0,
            paginas: 0
        };
        this.pagina = this.setPagina();
        this.idOriginal = null;
        this.url = (process.env.REACT_APP_API_URL || 'http://localhost:8081/') + 'catalogo/pelicula';
    }

    setPagina() {
        return 0;
    }

    setError(msg) {
        this.setState({ error: msg, loading: false });
    }

    list(num) {
        let pagina = this.state.pagina
        if (num || num === 0) pagina = num
        this.setState({ loading: true });
        fetch(`${this.url}/page/${pagina}`)
            .then(response => {
                response.json().then(response.ok ? data => {

                    this.setState({
                        modo: "list",
                        listado: data,
                        loading: false,
                        pagina: data.number,
                        paginas: data.totalPages
                    })
                } : error => this.setError(`${error.status}: ${error.error}`))
            })
            .catch(error => this.setError(error))
    }

    add() {
        this.setState({
            modo: "add",
            elemento: { filmId: 0, description: "", length: 0, rating:"", releaseYear:0,rentalDuration:0,rentalRate:0,replacementCost:0,title:""}
        });
    }
    edit(key) {
        this.setState({ loading: true });
        fetch(`${this.url}/${key}`, { method: 'PUT' })
            .then(response => {  
                response.json().then(response.ok ? data => {
                    this.setState({
                        modo: "edit",
                        elemento: data,
                        loading: false
                    });
                    this.idOriginal = key;
                } : error => this.setError(`${error.status}: ${error.error}`))
            })
            .catch(error => this.setError(error))
    }

    view(key) {
        this.setState({ loading: true });
        fetch(`${this.url}/${key}`)
            .then(response => {
                response.json().then(response.ok ? data => {
                    this.setState({
                        modo: "view",
                        elemento: data,
                        loading: false
                    });
                } : error => this.setError(`${error.status}: ${error.error}`))
            })
            .catch(error => this.setError(error))
    }
    delete(key) {
        if (!window.confirm("¿Seguro?")) return;
        this.setState({ loading: true });
        console.log("Lllegamos a delete")
        fetch(`${this.url}/${key}`,{ method: 'DELETE' })
            .then(response => {
                if (response.ok)
                    this.list(this.setPagina())
                else
                    response.json().then(error => this.setError(`${error.status}:
                        ${error.error}`))
                this.setState({ loading: false });
            })
            .catch(error => this.setError(error))
    }



    componentDidMount(value) {
        this.list(this.setPagina());
    }


    cancel() {
        this.list(this.setPagina());
    }
    send(elemento) {
        this.setState({ loading: true });
        // eslint-disable-next-line default-case
        switch (this.state.modo) {
            case "add":
                fetch(`${this.url}`, {
                    method: 'POST',
                    body: JSON.stringify(elemento),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                    .then(response => {
                        if (response.ok)
                            this.cancel(this.setPagina())
                        else
                            response.json().then(error => this.setError(`${error.status}:
                ${error.detail}`))
                        this.setState({ loading: false });
                    })
                    .catch(error => this.setError(error))
                break;
            case "edit":
                fetch(`${this.url}/${this.idOriginal}`, {
                    method: 'PUT',
                    body: JSON.stringify(elemento),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                    .then(response => {
                        if (response.ok)
                            this.cancel(this.setPagina())
                        else
                            response.json().then(error => this.setError(`${error.status}:
                ${error.detail}`))
                        this.setState({ loading: false });
                    })
                    .catch(error => this.setError(error))
                break;
        }
    }

    render() {
        if (this.state.loading) return <Esperando />;
        let result = [<ErrorMessage key="error" msg={this.state.error} onClear={() =>
            this.setState({ error: null })} />]
        switch (this.state.modo) {
            case "add":
                result.push(<ActorForm/>); break
            case "edit":
                result.push(
                    <ActoresForm key="main"
                        isAdd={this.state.modo === "add"}
                        elemento={this.state.elemento}
                        onCancel={e => this.cancel(this.setPagina())}
                        onSend={e => this.send(e)}
                    />
                )
                break
            case "view":
                result.push(
                    <ActoresView key="main"
                        elemento={this.state.elemento}
                        onCancel={e => this.cancel()}
                    />
                )
                break
            default:
                if (this.state.listado) result.push(
                    <ActoresList key="main"
                        listado={this.state.listado}
                        pagina={this.state.pagina}
                        paginas={this.state.paginas}
                        onAdd={e => this.add()}
                        onView={key => this.view(key)}
                        onEdit={key => this.edit(key)}
                        onDelete={key => this.delete(key)}
                        onChangePage={num => this.list(this.setPagina())}
                    />
                );
                break;
        }
        return result
    }



}


function ActoresList(props) {
    return (
        <>
            <table className="table table-hover table-striped">
                <thead className="table-info">
                    <tr>
                        <th>Lista de Actores y Actrices</th>
                        <th className="text-end">
                            <input
                                type="button" className="btn btn-primary"
                                value="Añadir" onClick={e => props.onAdd()}
                            />
                        </th>
                    </tr>
                </thead>
                <tbody className="table-group-divider">
                    {props.listado.map(item => (
                        <tr key={item.filmId}>
                            <td>
                                {titleCase(item.title)}
                            </td>
                            <td className="text-end">
                                <div className="btn-group text-end" role="group">
                                    <input type="button" className="btn btn-primary"
                                        value="Ver" onClick={e => props.onView(item.filmId)}
                                    />
                                    <input type="button" className="btn btn-danger"
                                        value="Borrar"
                                        onClick={e => props.onDelete(item.filmId)}
                                    />
                                    
                            
                                </div>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <Paginacion actual={props.pagina} total={props.paginas} onChange={num =>
                props.onChangePage(num)} />
        </>
    )
}

function ActoresView({ elemento, onCancel }) {
    return (
        <div>
            <p>
                <b>Código:</b> {elemento.filmId}
                <br />
                <b>Titulo:</b> {elemento.title}
                <br />
                <b>Descripcion:</b> {elemento.description}
                <br />
                <b>Duración:</b> {elemento.length}
                <br />
                <b>Rating:</b> {elemento.rating}
                <br />
                <b>Año de lanzamiento:</b> {elemento.releaseYear}
                <br />
                <b>Duración Publicidad:</b> {elemento.rentalDuration}
                <br />
                <b>Rate:</b> {elemento.rentalRate}
                <br />
                <b>Coste de remplazo:</b> {elemento.replacementCost}
                
            </p>
            <p>
                <button
                    className="btn btn-primary"
                    type="button"
                    onClick={e => onCancel()}
                >
                    Volver
                </button>
            </p>
        </div>
    )
}


class ActoresForm extends Component {
    constructor(props) {
        super(props);
        this.state = { elemento: props.elemento, msgErr: [], invalid: false };
        this.handleChange = this.handleChange.bind(this);
        this.onSend = () => {
            if (this.props.onSend) this.props.onSend(this.state.elemento);
        };
        this.onCancel = () => {
            if (this.props.onCancel) this.props.onCancel(this.setPagina());
        };
    }
    handleChange(event) {
        const cmp = event.target.name;
        const valor = event.target.value;
        this.setState(prev => {
            prev.elemento[cmp] = valor;
            return { elemento: prev.elemento };
        });
        this.validar();
    }
    validarCntr(cntr) {
        if (cntr.name) {
            // eslint-disable-next-line default-case
            switch (cntr.name) {
                case "apellidos":
                    cntr.setCustomValidity(cntr.value !== cntr.value.toUpperCase()
                        ? "Debe estar en mayúsculas" : '');
                    break;
            }
        }
    }
    validar() {
        if (this.form) {
            const errors = {};
            let invalid = false;
            for (var cntr of this.form.elements) {
                if (cntr.name) {
                    this.validarCntr(cntr);
                    errors[cntr.name] = cntr.validationMessage;
                    invalid = invalid || !cntr.validity.valid;
                }
            }
            this.setState({ msgErr: errors, invalid: invalid });
        }
    }
    componentDidMount() {
        this.validar();
    }
    render() {
        return (
            <form
                ref={tag => {
                    this.form = tag;
                }}
            >
                <div className="form-group">
                    <label htmlFor="id">Código</label>
                    <input type="number"
                        className={'form-control' + (this.props.isAdd ? '' : '-plaintext')}
                        id="id" name="id"
                        value={this.state.elemento.id}
                        onChange={this.handleChange}
                        required readOnly={!this.props.isAdd}
                    />
                    <ValidationMessage msg={this.state.msgErr.id} />
                </div>
                <div className="form-group">
                    <label htmlFor="nombre">Nombre</label>
                    <input type="text" className="form-control"
                        id="firstName" name="firstName"
                        value={this.state.elemento.firstName}
                        onChange={this.handleChange}
                        required minLength="2" maxLength="45"
                    />
                    <ValidationMessage msg={this.state.msgErr.firstName} />
                </div>
                <div className="form-group">
                    <label htmlFor="lastName">Apellidos</label>
                    <input type="text" className="form-control"
                        id="lastName" name="lastName"
                        value={this.state.elemento.lastName}
                        onChange={this.handleChange}
                        minLength="2" maxLength="10"
                    />
                    <ValidationMessage msg={this.state.msgErr.lastName} />
                </div>
                <div className="form-group">
                    <button className="btn btn-primary" type="button"
                        disabled={this.state.invalid}
                        onClick={this.onSend}
                    >
                        Enviar
                    </button><button className="btn btn-primary" type="button"
                        onClick={this.onCancel}
                    >
                        Volver
                    </button>
                </div>
            </form>
        );
    
    
    
    }


    


    
}


class ActorForm extends Component {
    constructor(props) {
      super(props);
  
      this.state = {
        actorId: '',
        firstName: '',
        lastName: ''
      };
  
      this.handleSubmit = this.handleSubmit.bind(this);
      this.handleInputChange = this.handleInputChange.bind(this);
    }
  
    handleSubmit(event) {
      event.preventDefault();
  
      const { actorId, firstName, lastName } = this.state;
  
      fetch('http://localhost:8081/catalogo/actor/', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          actorId: actorId,
          firstName: firstName,
          lastName: lastName
        })
      })
      .then(response => response.json())
      .then(data => console.log(data))
      .catch(error => console.error(error));
    }
  
    handleInputChange(event) {
      const target = event.target;
      const value = target.value;
      const name = target.name;
  
      this.setState({
        [name]: value
      });
    }
  
    render() {
      const { actorId, firstName, lastName } = this.state;
  
      return (
        <form onSubmit={this.handleSubmit}>
          <label>
            Actor ID:
            <input
              type="number"
              name="actorId"
              value={actorId}
              onChange={this.handleInputChange}
            />
          </label>
          <br />
          <label>
            First Name:
            <input
              type="text"
              name="firstName"
              value={firstName}
              onChange={this.handleInputChange}
            />
          </label>
          <br />
          <label>
            Last Name:
            <input
              type="text"
              name="lastName"
              value={lastName}
              onChange={this.handleInputChange}
            />
          </label>
          <br />
          <button type="submit">Submit</button>
        </form>
      );
    }
  }