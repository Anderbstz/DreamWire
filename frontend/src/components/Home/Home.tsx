import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css';

const Home: React.FC = () => {
  return (
    <div className="home-container">
      <nav className="navbar">
        <div className="nav-brand">DreamWire</div>
        <div className="nav-links">
          <Link to="/login" className="nav-link">Iniciar Sesión</Link>
          <Link to="/register" className="nav-button">Registrarse</Link>
        </div>
      </nav>

      <main className="hero-section">
        <div className="hero-content">
          <h1>DREAMWIRE</h1>
          <p className="subtitle">Tu plataforma de desarrollo web integral</p>
          <div className="emoji-container">🚀</div>
          <div className="features-grid">
            <div className="feature-card">
              <h3>Spring Boot Backend</h3>
              <p>API REST robusta y escalable con Spring Boot, diseñada para un rendimiento óptimo.</p>
            </div>
            <div className="feature-card">
              <h3>React Frontend</h3>
              <p>Interfaz de usuario moderna y responsive construida con React y las últimas tecnologías web.</p>
            </div>
            <div className="feature-card">
              <h3>Seguridad Integrada</h3>
              <p>Autenticación y autorización robusta para proteger tus datos y usuarios.</p>
            </div>
            <div className="feature-card">
              <h3>Diseño Minimalista</h3>
              <p>Experiencia de usuario limpia y moderna con enfoque en la usabilidad.</p>
            </div>
          </div>
          <Link to="/register" className="cta-button">Comenzar Ahora</Link>
        </div>
      </main>

      <footer className="footer">
        <p>© 2024 DreamWire. Todos los derechos reservados.</p>
      </footer>
    </div>
  );
};

export default Home;