export default function QuienesSomos() {
    return (
        <>
            <section className="py-16 px-4">
                <div className="container mx-auto max-w-6xl mb-12">
                    <h2 className="text-4xl font-bold mb-6 text-center">Nuestra Identidad</h2>
                    <div className="grid text-justify md:grid-cols-2 gap-12 items-center">
                        <div>
                            <p className="text-lg text-gray-600 leading-relaxed mb-6">
                                Somos una empresa mexicana fundada en 2020, especializada en brindar soluciones integrales de mantenimiento industrial correctivo y preventivo. Desde nuestros inicios, nos hemos enfocado en ofrecer un servicio confiable, seguro y adaptado a las necesidades operativas de nuestros clientes.
                            </p>
                            <p className="text-lg text-gray-600 leading-relaxed">
                                Gracias a nuestro compromiso con la calidad, la seguridad y la mejora continua, en tan solo cinco años hemos ampliado significativamente nuestro portafolio de servicios, incorporando trabajos especializados como:
                            </p>
                            <ul className="list-disc list-inside space-y-2 text-gray-700 font-bold my-3">
                                <li className="text-md text-gray-600 ">Trabajos en caliente (soldadura, corte, etc.).</li>
                                <li className="text-md text-gray-600">Trabajos en espacios confinados.</li>
                                <li className="text-md text-gray-600">Trabajos en alturas.</li>
                                <li className="text-md text-gray-600">Instalaciones y mantenimientos eléctricos.</li>
                            </ul>
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
