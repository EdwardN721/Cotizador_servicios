import { Target, Star } from "lucide-react"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/Card.jsx";

export default function MisionVision() {
    return (
        <>
                <Card></Card>
            <section className="py-16 px-4 bg-gray-50">
                <div className="container mx-auto max-w-6xl">
                    <h2 className="text-4xl font-bold text-center mb-12">Misión y Visión</h2>
                    <div className="grid md:grid-cols-2 gap-8">
                        <Card className="border-l-4 border-l-blue-500">
                            <CardHeader>
                                <div className="flex items-center gap-2 mb-2">
                                    <Target className="w-6 h-6 text-blue-500" />
                                    <CardTitle className="text-2xl">Nuestra Misión</CardTitle>
                                </div>
                            </CardHeader>
                            <CardContent>
                                <p className="text-gray-600 leading-relaxed">
                                    Brindar servicios integrales de mantenimiento industrial con altos estándares de calidad, seguridad y eficiencia, adaptados a las necesidades específicas de cada cliente. <br />Nos comprometemos con la mejora continua, la innovación y la atención personalizada, para garantizar la máxima operatividad y confiabilidad de los sistemas industriales.
                                </p>
                            </CardContent>
                        </Card>

                        <Card className="border-l-4 border-l-purple-500">
                            <CardHeader>
                                <div className="flex items-center gap-2 mb-2">
                                    <Star className="w-6 h-6 text-purple-500" />
                                    <CardTitle className="text-2xl">Nuestra Visión</CardTitle>
                                </div>
                            </CardHeader>
                            <CardContent>
                                <p className="text-gray-600 leading-relaxed">
                                    Ser una empresa líder a nivel nacional en mantenimiento industrial, reconocida por nuestra excelencia operativa, compromiso con nuestros clientes y capacidad de crecimiento sostenible. <br />Aspiramos a expandir nuestros servicios en todo el país, fortaleciendo relaciones de largo plazo con empresas de todos los sectores industriales.
                                </p>
                            </CardContent>
                        </Card>
                    </div>
                </div>
            </section>
        </>
    )
}
