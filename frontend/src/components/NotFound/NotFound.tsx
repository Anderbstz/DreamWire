import React from 'react';
import { Link } from 'react-router-dom';
import './NotFound.css';

const NotFound: React.FC = () => {
  return (
    <div className="not-found-container">
      <div className="not-found-card">
        <h1 className="not-found-title">404</h1>
        <h2>Página no encontrada</h2>
        <p>Lo sentimos, la página que estás buscando no existe o ha sido movida.</p>
        <p>Por favor, verifica la URL o regresa al inicio para continuar navegando.</p>
        <Link to="/" className="not-found-button">
          Volver al inicio
        </Link>
      </div>
    </div>
  );
};

export default NotFound;