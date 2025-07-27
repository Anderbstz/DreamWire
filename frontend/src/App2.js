import React, { useEffect, useState } from "react";

export default function App() {
  const [dashboard, setDashboard] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/api/dashboard/", {
      headers: {
        Authorization: "Bearer mock-jwt-user-1234567890"
      }
    })
      .then(res => res.json())
      .then(data => setDashboard(data));
  }, []);

  if (!dashboard) return <div>Cargando...</div>;

  return (
    <div>
      <h1>{dashboard.title}</h1>
      <p>{dashboard.message}</p>
      <pre>{JSON.stringify(dashboard, null, 2)}</pre>
    </div>
  );
}