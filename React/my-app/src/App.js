import logo from './logo.svg';
import './App.css';
import './estilos.css';
import {ActoresMnt} from './componentes/actores.js'
import React, { Component, useState } from 'react'
import { Card, Contador } from './componentes';
import { ErrorBoundary } from './biblioteca/comunes.js';
import Muro from './galeria/muro';
import { PadreFormulario } from './formulario/formulario.js';

export class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
        cont: 0,
        main: 0,
        displayValue: ''
    }
    this.menu = [
      { texto: 'actores', url: '/actores', componente: <ActoresMnt /> },
      { texto: 'fromulario', url: '/fromulario', componente: <PadreFormulario /> },
      { texto: 'muro', url: '/muro', componente: <Muro /> },
      { texto: 'calculadora', url: '/', componente: <Calculator />},
      { texto: 'calculadora2', url: '/2', componente: <Calculator2 />},
      { texto: 'inicio', url: '/inicio', componente: <Home />},
      { texto: 'demos', url: '/demos', componente: <DemosJSX /> },
      { texto: 'contador', url: '/contador', componente: <Contador init={69} />},
      { texto: 'ejemplos', url: '/ejemplos', componente: <Ejemplos />},
    ]
  }

  render() {
    return (
      <>
        <Cabecera menu={this.menu} onSelectMenu={indice => this.setState({main: indice})} />
        <main className='container-fluid'>
          <ErrorBoundary>
          {this.menu[this.state.main].componente}
          </ErrorBoundary>
        </main>
        <Pie />
      </>
    )
  }
}


function Cabecera(props) {
  return (
    <header>
      <Menu {...props} />
    </header>
  );
}

function Menu({menu, onSelectMenu}) {
  return (
    <nav>
      {menu.map((item, index) => 
        <button key={index} type='button' onClick={() => onSelectMenu && onSelectMenu(index)}>{item.texto}</button>)
      }
    </nav>
  );
}

function Pie() {
  return null;
}

export class Ejemplos extends Component {
    constructor(props) {
      super(props)
      this.state = {
          cont: 0,
      }
     }
  
    render() {
      return (
        <>
          <main className='container-fluid'>
            <Card tittle="Ejemplo de componente">
              <Contador init={10} delta={2} 
                onChange={num => this.setState({cont: num})} />
            </Card>
            <p>El contador: {this.state.cont}</p>
            <input className='btn btn-bg-danger' type='button' value='No tocar' onClick={() => { throw new Error('No tocar')} } />
          </main>
        </>
      )
    }
  }

class DemosJSX extends Component {
  render() {
    let nombre = '<b>mundo</b>'
    let estilo = 'App-link'
    let saluda = <h1>Hola {nombre.toUpperCase() + '!'}!!</h1>
    let dim = { width: 100, height: 50 }
    let errorStyle = { color: 'white', backgroundColor: 'red' }
    let limpia = true
    let falsa
    let list = [
      {id: 1,nombre:'Madrid'},
      {id: 2,nombre:'Barcelona'},
      {id: 3,nombre:'Sevilla'},
      {id: 4,nombre:'Valencia'},
    ]
    return (
      <>
        {saluda}
        {limpia ? <b>verdadero</b> : <i>falso {nombre}</i>}
        {limpia && <h2>Limpia</h2>}
        {/* {falsa ?? <b>no existe</b>} */}
        {/* {falsa !== null && falsa.persona !== null && falsa.persona.nombre} */}
        {falsa?.persona?.nombre ?? <b>no existe</b>}
        <div style={{ color: 'white', backgroundColor: 'red' }}>DemosJSX</div>
        <h2 className={estilo} style={errorStyle} >Hola
          <span dangerouslySetInnerHTML={{ __html: nombre }} /></h2>
          <ul>
            {[1,2,3,4, 3, 2, 1].map((item,index) => <li key={index}>Elemento {item}</li>)}
          </ul>
          <select>
            {list.map(item => <option key={item.id} value={item.id}>{item.nombre}</option>)}
          </select>
          <img src={logo} className="App-logo" alt="logo" {...dim} hidden={false} />
      </>
    )
  }
}

function Home() {
  let url = process.env.REACT_APP_API_URL
  
  return (
    // eslint-disable-next-line jsx-quotes
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>Hola mundo</h1>
        <h2>url: {url}</h2>
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}


function Calculator() {

  
  const [result, setResult] = useState("");

  function handleClick(event) {
    setResult(result.concat(event.target.name));
  }

  function handleClear() {
    setResult("");
  }

  function handleDelete() {
    setResult(result.slice(0, -1));
  }

  function handleEqual() {
    try {
      setResult(eval(result).toString());
    } catch (error) {
      setResult("Error");
    }
  }

  const Display = (props) => {
    return (
      <div className="display">
        {props.value || '0'}
      </div>
    )
  }

  return (
    <div className="container mt-5" style={{width: "400px"}}>
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card">
            <div className="card-header">Calculator</div>
            <div className="card-body">
              <Display className="display" value={result}></Display>
              <div className="buttons">
                <button onClick={handleClear} className="btn btn-danger mr-2">
                  AC
                </button>
                <button onClick={handleDelete} className="btn btn-secondary mr-2">
                  C
                </button>
                <button onClick={handleClick} className="btn btn-secondary mr-2" name="/">
                  ÷
                </button>
                <br/>
                <button onClick={handleClick} className="btn btn-light mr-2" name="7">
                  7
                </button>
                <button onClick={handleClick} className="btn btn-light mr-2" name="8">
                  8
                </button>
                <button onClick={handleClick} className="btn btn-light mr-2" name="9">
                  9
                </button>
                <button onClick={handleClick} className="btn btn-secondary mr-2" name="*">
                  ×
                </button>
                <br/>
                <button onClick={handleClick} className="btn btn-light mr-2" name="4">
                  4
                </button>
                <button onClick={handleClick} className="btn btn-light mr-2" name="5">
                  5
                </button>
                <button onClick={handleClick} className="btn btn-light mr-2" name="6">
                  6
                </button>
                <button onClick={handleClick} className="btn btn-secondary mr-2" name="-">
                  -
                </button>
                 <br/>
                <button onClick={handleClick} className="btn btn-light mr-2" name="1">
                  1
                </button>
                <button onClick={handleClick} className="btn btn-light mr-2" name="2">
                  2
                </button>
                <button onClick={handleClick} className="btn btn-light mr-2" name="3">
                  3
                </button>
                <button onClick={handleClick} className="btn btn-secondary mr-2" name="+">
                  +
                </button>
                <br/> 
                <button onClick={handleClick} className="btn btn-light mr-2" name="0">
                  0
                </button>
                <button onClick={handleClick} className="btn btn-light mr-2" name=".">
                  .
               </button>
               <button onClick={handleEqual} className="btn btn-light mr-2" name="equal">
                 =
                </button>
        </div>
      </div>
      </div>
      </div>
      </div>
      </div>
    
    );
}



function Calculator2() {

  
  

  const Display = (props) => {
    return (
      <div className="display">
        {props.value || '0'}
      </div>
    )
  }

  return (
    <>
  <div className="container" style={{ marginTop: 100, marginLeft: 800 }}>
    <div className="row">
      <div className="col-xs-12" id="titulo">
        <h3>Calculadora Básica</h3>
      </div>
    </div>
  </div>
  <div className="container " style={{ marginLeft: 800 }}>
    <div className="row align-items-center">
      <div className="col-xs-12 col-sm-6 col-md-3 fundo-mod margem borda">
        <div className="justify-content-center centro">
          <table className="table table-dark">
            <tbody>
              <tr>
                <td colSpan={4}>
                  <div id="historico" />
                </td>
              </tr>
              <tr>
                <td colSpan={4} id="locooo">
                  <input
                    type="text"
                    name="visor"
                    id="visor"
                    className="col-xs-12 col-sm-12 col-md-12"
                  />
                  By: Daniel García
                </td>
              </tr>
              <tr>
                <td>
                  <input
                    type="button"
                    id="boton7"
                    defaultValue={7}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(7);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton8"
                    defaultValue={8}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(8);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton9"
                    defaultValue={9}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(9);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton/"
                    defaultValue="/"
                    className="btn btn-info mesmo-tamanho"
                    onclick="btn_divide();"
                  />
                </td>
              </tr>
              <tr>
                <td>
                  <input
                    type="button"
                    id="boton4"
                    defaultValue={4}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(4);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton5"
                    defaultValue={5}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(5);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton6"
                    defaultValue={6}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(6);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton*"
                    defaultValue="*"
                    className="btn btn-info mesmo-tamanho"
                    onclick="btn_multiplica();"
                  />
                </td>
              </tr>
              <tr>
                <td>
                  <input
                    type="button"
                    id="boton1"
                    defaultValue={1}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(1);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton2"
                    defaultValue={2}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(2);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton3"
                    defaultValue={3}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(3);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton-"
                    defaultValue="-"
                    className="btn btn-info mesmo-tamanho"
                    onclick="btn_resta();"
                  />
                </td>
              </tr>
              <tr>
                <td>
                  <input
                    type="button"
                    id="boton0"
                    defaultValue={0}
                    className="btn btn-secondary mesmo-tamanho"
                    onclick="boton(value);"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton="
                    defaultValue="="
                    className="btn btn-info mesmo-tamanho"
                    onclick="btn_igual();"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="botonC"
                    defaultValue="C"
                    className="btn btn-danger mesmo-tamanho"
                    onclick="reset();"
                  />
                </td>
                <td>
                  <input
                    type="button"
                    id="boton+"
                    defaultValue="+"
                    className="btn btn-info mesmo-tamanho"
                    onclick="btn_suma();"
                  />
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</>

    
    );
}
  