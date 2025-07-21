import React from "react";

export default function Historia() {
    const anioInicio = 2020

    return (
        <section className="max-w-4xl mx-auto px-6 py-12">
            <div className="space-y-8">
                {/* Título y año de inicio */}
                <div className="text-center space-y-4">
                    <h2 className="text-3xl md:text-4xl font-bold text-gray-900">Historia de la Empresa</h2>
                    <div className="inline-flex items-center px-4 py-2 bg-blue-100 rounded-full">
                        <span className="text-blue-800 font-semibold">Fundada en {anioInicio}</span>
                    </div>
                </div>

                {/* Contenido de la historia */}
                <div className="space-y-6 text-gray-700 leading-relaxed">
                    <p className="text-lg">
                        Nuestra empresa nació en el año 2020, en medio de un contexto desafiante y con una visión clara:
                        ofrecer servicios de mantenimiento industrial correctivo y preventivo que marcaran la diferencia por su calidad, responsabilidad y enfoque humano.
                    </p>

                    <p className="text-lg">
                        Con esfuerzo, dedicación y un fuerte compromiso con la seguridad industrial, logramos ganar la confianza de nuestro primer cliente: Procter & Gamble,
                        una de las empresas más importantes del sector manufacturero a nivel mundial. Esta oportunidad marcó el inicio de nuestro camino y fue un punto de partida que nos impulsó a mantener los más altos estándares desde el primer día.
                    </p>

                    <p className="text-lg">
                        Hoy, somos una empresa que sigue creciendo, con presencia cada vez más sólida en distintos sectores industriales, y con un objetivo claro: consolidarnos como un referente nacional en mantenimiento industrial especializado,
                        sin perder la cercanía, la integridad y la calidad que nos identifican desde el primer día.                    </p>
                </div>
            </div>
        </section>
    )
}
