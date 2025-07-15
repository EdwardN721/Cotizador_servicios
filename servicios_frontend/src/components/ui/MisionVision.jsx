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
                                    Proporcionar soluciones innovadoras y de alta calidad que impulsen el crecimiento y éxito de nuestros
                                    clientes, manteniendo siempre los más altos estándares de integridad y excelencia en el servicio.
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
                                    Ser reconocidos como la empresa líder en nuestro sector, destacando por nuestra innovación, calidad y
                                    compromiso con la sostenibilidad, creando valor para todos nuestros stakeholders.
                                </p>
                            </CardContent>
                        </Card>
                    </div>
                </div>
            </section>
        </>
    )
}
