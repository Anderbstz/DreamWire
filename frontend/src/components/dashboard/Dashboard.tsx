import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../../App';
import './Dashboard.css';

interface Project {
  id: number;
  name: string;
  description: string;
  status: string;
  progress: number;
}

const Dashboard: React.FC = () => {
  const navigate = useNavigate();
  const { user, logout } = useAuth();
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [projects, setProjects] = useState<Project[]>([
    {
      id: 1,
      name: 'E-commerce App',
      description: 'Aplicación de comercio electrónico con Spring Boot y React',
      status: 'En progreso',
      progress: 65
    },
    {
      id: 2,
      name: 'Blog Personal',
      description: 'Blog con sistema de gestión de contenidos',
      status: 'Pendiente',
      progress: 20
    }
  ]);

  useEffect(() => {
    const fetchDashboardData = async () => {
      try {
        const token = localStorage.getItem('token');
        if (!token) {
          navigate('/login');
          return;
        }

        const response = await fetch('http://localhost:8080/api/dashboard/', {
          headers: {
            'Authorization': token
          }
        });

        if (!response.ok) {
          if (response.status === 401) {
            logout();
            navigate('/login');
            return;
          }
          throw new Error('Error al cargar el dashboard');
        }

        const data = await response.json();
        setProjects(data.projects || []);
      } catch (err) {
        setError('Error al cargar los datos del dashboard');
        console.error(err);
      } finally {
        setLoading(false);
      }
    };

    fetchDashboardData();
  }, [navigate, logout]);

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  if (loading) {
    return <div className="loading-spinner">Cargando...</div>;
  }

  if (error) {
    return <div className="error-message">{error}</div>;
  }

  return (
    <div className="dashboard-container">
      <nav className="dashboard-nav">
        <div className="nav-brand">🚀 DreamWire</div>
        <div className="nav-menu">
          <span className="user-welcome">Bienvenido, {user?.name}</span>
          <button className="nav-button" onClick={handleLogout}>Cerrar Sesión</button>
        </div>
      </nav>

      <div className="dashboard-content">
        <header className="dashboard-header">
          <h1>Mi Dashboard</h1>
          <p>Bienvenido de nuevo. Aquí están tus proyectos actuales.</p>
        </header>

        <div className="stats-container">
          <div className="stat-card">
            <h3>Proyectos Totales</h3>
            <p className="stat-number">{projects.length}</p>
          </div>
          <div className="stat-card">
            <h3>En Progreso</h3>
            <p className="stat-number">{projects.filter(p => p.status === 'En progreso').length}</p>
          </div>
          <div className="stat-card">
            <h3>Completados</h3>
            <p className="stat-number">{projects.filter(p => p.status === 'Completado').length}</p>
          </div>
        </div>

        <section className="projects-section">
          <h2>Mis Proyectos</h2>
          <div className="projects-grid">
            {projects.map(project => (
              <div key={project.id} className="project-card">
                <h3>{project.name}</h3>
                <p>{project.description}</p>
                <div className="project-status">
                  <span className={`status-badge ${project.status.toLowerCase()}`}>
                    {project.status}
                  </span>
                </div>
                <div className="progress-bar">
                  <div 
                    className="progress-fill"
                    style={{ width: `${project.progress}%` }}
                  ></div>
                </div>
                <p className="progress-text">{project.progress}% Completado</p>
              </div>
            ))}
          </div>
        </section>
      </div>
    </div>
  );
};

export default Dashboard;