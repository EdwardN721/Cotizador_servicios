import React from "react";
import Boton from "./Boton.jsx";

export default function Hero() {

    return (
        <div className="relative py-20 px-4 text-center ">
            <div className="text-white container mx-auto max-w-6xl">
                <div className="m-5 p-5 w-full h-full flex justify-center items-center">
                    <img
                        src="../../../src/assets/images/logo.png"
                        alt="Logo de la empresa"
                        className="w-3/6 mx-auto mb-6 bg-white/10 rounded-lg p-4"
                    />
                </div>
                <h1 className="text-5xl md:text-6xl font-bold mb-6">Bienvenidos a nuestra empresa</h1>
                <p className="text-xl md:text-2xl mb-8 max-w-3xl mx-auto opacity-90">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                </p>
                <div className="flex flex-col sm:flex-row gap-4 justify-center">
                    <Boton valor="Sobre nosotros" />
                    <Boton valor="Nuestros servicios" />
                </div>
            </div>
        </div>
    )
}