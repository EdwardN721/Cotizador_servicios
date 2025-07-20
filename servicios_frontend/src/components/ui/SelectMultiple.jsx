import React from "react"
import {AlertCircle} from "lucide-react";

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


    return (
        <div>
            <label className="font-medium">Servicios que te interesan</label>
            <div className={`flex flex-wrap gap-2 mt-2 ${error ? "border border-red-500 p-2 rounded" : ""}`}>
                {servicios.map((servicio) => (
                    <button
                        key={servicio}
                        type="button"
                        className={`flex items-center gap-2 px-3 py-1 rounded-full border transition-all duration-200 ease-in-out ${
                            serviciosSeleccionados.includes(servicio)
                                ? "bg-blue-600 text-white border-blue-600 shadow-md animate-pulseFast"
                                : "bg-white text-gray-700 border-gray-300 hover:bg-blue-100"
                        }`}
                        onClick={() => toggleServicio(servicio)}
                    >
                        {serviciosSeleccionados.includes(servicio) && <span>✅</span>}
                        {servicio}
                    </button>
                ))}
            </div>
            {error && (
                <p className="text-red-500 text-sm mt-1 flex items-center">
                    <AlertCircle className="w-4 h-4 mr-1 text-red-500" />
                    Selecciona al menos un servicio!.
                </p>
            )}
        </div>
    );
}