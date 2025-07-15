import React from "react";

export default function Boton({valor}) {

    const [estadoBoton, setEstadoBoton] = React.useState(false);
    return (
        <>
            <input type="button"
                   value={valor}
            className="bg-white text-blue-600 hover:bg-gray-100 py-2 px-3 rounded-lg"
            onClick={() => setEstadoBoton(!estadoBoton)}
            />
        </>
    );
}