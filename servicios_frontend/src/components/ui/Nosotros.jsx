import trabajo from "@/assets/images/trabajo.png";

export default function Nosotros() {
    return (
        <>
            <section className="py-16 px-4">
                <div className="container mx-auto max-w-6xl">
                    <div className="grid md:grid-cols-2 gap-12 items-center">
                        <div>
                            <h2 className="text-4xl font-bold mb-6">¿Por Qué Confiar en Nosotros?</h2>
                            <p className="text-lg text-justify text-gray-600 mb-6">
                                En nuestra empresa, creemos que las personas son el motor de nuestro crecimiento. Por eso, cultivamos un ambiente laboral seguro, eficiente y colaborativo, donde cada integrante aporta con responsabilidad, experiencia y compromiso.
                                <br />Contamos con un equipo técnico altamente capacitado, especializado en diversas áreas como soldadura, electricidad, automatización, trabajos en alturas, espacios confinados, plomería, obra civil y más. Cada miembro recibe capacitaciones continuas en nuevas tecnologías, normativas de seguridad, buenas prácticas operativas y servicio al cliente.
                            </p>
                            <div className="grid grid-cols-2 gap-6 mb-6">
                                <div className="text-center">
                                    <div className="text-3xl font-bold text-blue-600 mb-2">🛠️</div>
                                    <div className="text-sm text-gray-600">Cultura de seguridad industrial.</div>
                                </div>
                                <div className="text-center">
                                    <div className="text-3xl font-bold text-blue-600 mb-2">📚</div>
                                    <div className="text-sm text-gray-600">Capacitación constante.</div>
                                </div>
                                <div className="text-center">
                                    <div className="text-3xl font-bold text-blue-600 mb-2">🤝</div>
                                    <div className="text-sm text-gray-600">Buen clima laboral.</div>
                                </div>
                                <div className="text-center">
                                    <div className="text-3xl font-bold text-blue-600 mb-2">⚙️</div>
                                    <div className="text-sm text-gray-600">Operaciones eficientes.</div>
                                </div>
                            </div>
                        </div>
                        <div className="relative">
                            <img
                                src={trabajo}
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
