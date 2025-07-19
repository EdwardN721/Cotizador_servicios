export default function Nosotros() {
    return (
        <>
            <section className="py-16 px-4">
                <div className="container mx-auto max-w-6xl">
                    <div className="grid md:grid-cols-2 gap-12 items-center">
                        <div>
                            <h2 className="text-4xl font-bold mb-6">¿Por Qué Confiar en Nosotros?</h2>
                            <p className="text-lg text-gray-600 mb-6">
                                Con más de 10 años de experiencia en el mercado, hemos ayudado a cientos de empresas a transformar
                                digitalmente sus negocios y alcanzar sus objetivos.
                            </p>
                            <div className="grid grid-cols-2 gap-6 mb-6">
                                <div className="text-center">
                                    <div className="text-3xl font-bold text-blue-600 mb-2">500+</div>
                                    <div className="text-sm text-gray-600">Proyectos Completados</div>
                                </div>
                                <div className="text-center">
                                    <div className="text-3xl font-bold text-blue-600 mb-2">98%</div>
                                    <div className="text-sm text-gray-600">Satisfacción del Cliente</div>
                                </div>
                                <div className="text-center">
                                    <div className="text-3xl font-bold text-blue-600 mb-2">24/7</div>
                                    <div className="text-sm text-gray-600">Soporte Técnico</div>
                                </div>
                                <div className="text-center">
                                    <div className="text-3xl font-bold text-blue-600 mb-2">50+</div>
                                    <div className="text-sm text-gray-600">Especialistas</div>
                                </div>
                            </div>
                        </div>
                        <div className="relative">
                            <img
                                src="../../../src/assets/images/trabajo.png"
                                alt="Equipo trabajando"
                                width={500}
                                height={400}
                                className="rounded-lg shadow-lg"
                            />
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}
