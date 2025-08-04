import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App.jsx';
import ServiciosPage from './js/serviciosPage.jsx';

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <BrowserRouter basename="/Cotizador_servicios/">
            <Routes>
                <Route path="/" element={<App />} />
                <Route path="/servicios" element={<ServiciosPage />} />
            </Routes>
        </BrowserRouter>
    </React.StrictMode>
);
