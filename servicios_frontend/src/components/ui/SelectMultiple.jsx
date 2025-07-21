import React from "react"
import {AlertCircle, CheckCircle} from "lucide-react";

const servicios = [
    "Mantenimiento industrial y especializado",
    "Pailería",
    "Servicios de corte y herramientas especializadas",
    "Instalaciones hidráulicas y sanitarias",
    "Pintura y acabados en espacios industriales y residenciales",
    "Instalaciones eléctricas y automatización",
    "Obra civil"
]

export default function SelectMultiple({ selected, setSelected, error }) {
    const serviciosSeleccionados = Array.isArray(selected) ? selected : [];

    const toggleServicio = (servicio) => {
        const nuevo = serviciosSeleccionados.includes(servicio)
            ? serviciosSeleccionados.filter((s) => s !== servicio)
            : [...serviciosSeleccionados, servicio];
        console.log("Seleccionados:", nuevo);
        setSelected(nuevo); // ← aquí está el cambio clave
    };

    const esValido = serviciosSeleccionados.length > 0;

    return (
        <div>
            <div className={`flex flex-wrap gap-2 mt-2 ${error ? "border border-red-500 p-2 rounded" : ""}`}>
                {servicios.map((servicio) => (
                    <button
                        key={servicio}
                        type="button"
                        className={`flex flex-wrap gap-2 mt-2 p-2 rounded-md border transition-all ${
                            error
                                ? "border-red-500 bg-red-50"
                                : esValido
                                    ? "border-green-500 bg-green-50"
                                    : "border-gray-300"
                        }`}
                        onClick={() => toggleServicio(servicio)}
                    >
                        {serviciosSeleccionados.includes(servicio) && <CheckCircle className="w-4 h-4" />}
                        {servicio}
                    </button>
                ))}
            </div>
            {error && (
                <p className="text-red-500 text-sm mt-2 flex items-center">
                    <AlertCircle className="w-4 h-4 mr-1 text-red-500" />
                    Selecciona al menos un servicio.
                </p>
            )}
        </div>
    );
}