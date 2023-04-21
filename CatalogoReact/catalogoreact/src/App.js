import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [actors, setActors] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(10);
  const [selectedActor, setSelectedActor] = useState(null);

  useEffect(() => {
    // Obtener los actores de la página actual al cargar la página
    axios.get(`http://localhost:8081/catalogo/actor/page/${currentPage}`)
      .then(response => {
        setActors(response.data);
        setTotalPages(response.data.totalPages);
      })
      .catch(error => console.log(error));
  }, [currentPage]);

  const handleActorClick = (actorId) => {
    // Obtener la información del actor al hacer clic en su botón
    axios.get(`http://localhost:8081/catalogo/actor/${actorId}`)
      .then(response => { 
        console.log(response)
        setSelectedActor(response.data)
      })
      .catch(error => console.log(error));
  };

  const handleDeleteActorClick = (actorId) => {
    // Eliminar el actor seleccionado
    axios.delete(`http://localhost:8081/catalogo/actor/${actorId}`)
      .then(response => {
        // Actualizar la lista de actores después de la eliminación
        setActors(actors.filter(actor => actor.actorId !== actorId));
      })
      .catch(error => console.log(error));
  };

  const handlePageChange = (page) => {
    setCurrentPage(page);
  };

  const pageNumbers = [];
  for (let i = 1; i <= totalPages; i++) {
    pageNumbers.push(i);
  }

  return (
    <div className="container mt-3">
      {selectedActor ? (
        <div>
          <h1>Información Actor</h1>
          <hr/>
          <h3>ID:</h3><span>{selectedActor.actorId}</span>
          <h3>Nombre:</h3><span>{selectedActor.firstName}</span>
          <h3>Apellido:</h3><span>{selectedActor.lastName}</span>
          <hr/>
          <button className="btn btn-primary" onClick={() => setSelectedActor(null)}>Volver</button>
        </div>
      ) : (
        <div>
          <h1 className="mb-3">Actores</h1>
          <ul className="list-group">
            {actors.map(actor => (
              <li key={actor.actorId} className="list-group-item d-flex justify-content-between align-items-center">
                {actor.firstName}
                <div>
                  <button className="btn btn-primary me-2" onClick={() => handleActorClick(actor.actorId)}>Ver información</button>
                  <button className="btn btn-danger" onClick={() => handleDeleteActorClick(actor.actorId)}>Eliminar</button>
                </div>
              </li>))}
            </ul>
          <nav aria-label="Page navigation example">
            <ul className="pagination">
              {pageNumbers.map(number => (
                <li key={number} className={`page-item ${currentPage === number ? 'active' : ''}`}>
                  <button className="page-link" onClick={() => handlePageChange(number)}>{number}</button>
                </li>
              ))}
            </ul>
          </nav>
        </div>
      )}
    </div>
  );
}
export default App;