import React from "react";

export default function QuienesSomos() {
    return (
        <>
            <section className="py-16 px-4">
                <div className="container mx-auto max-w-6xl text-center mb-12">
                    <h2 className="text-4xl font-bold mb-6">Nuestra Identidad</h2>
                    <div className="grid md:grid-cols-2 gap-12 items-center">
                        <div>
                            <p className="text-lg text-gray-600 leading-relaxed mb-6">
                                Somos una empresa líder en nuestro sector, comprometida con la excelencia y la innovación. Desde
                                nuestros inicios, hemos trabajado incansablemente para ofrecer soluciones de alta calidad que superen
                                las expectativas de nuestros clientes.
                            </p>
                            <p className="text-lg text-gray-600 leading-relaxed">
                                Nuestro equipo está formado por profesionales altamente capacitados que comparten la pasión por la
                                excelencia y el compromiso con el servicio al cliente.
                            </p>
                        </div>
                        <div className="relative">
                            <img
                                src="../../../src/assets/images/trabajo.png"
                                alt="Equipo trabajando"
                                className="w-5/6 h-5/6 rounded-lg shadow-lg"
                            />
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}