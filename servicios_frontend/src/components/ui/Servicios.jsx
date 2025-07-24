import { Card, CardContent, CardHeader, CardTitle, CardDescription } from "@/components/ui/Card.jsx"
import { Button } from "@/components/ui/Button.jsx"
import { servicios } from "../../assets/json/ServiciosJson.json";

export default function Servicios({ onScrollToForm }) {
    
    return (
        <>
            <section className="py-16 px-4">
                <div className="container mx-auto max-w-6xl">
                    <div className="text-center mb-12">
                        <h2 className="text-4xl font-bold mb-6">¿Qué Ofrecemos?</h2>
                        <p className="text-lg text-justify text-gray-600 max-w-5xl mx-auto">
                            Cada servicio está respaldado por nuestra experiencia, profesionalismo y compromiso con la seguridad, puntualidad y calidad técnica. Ya sea en un entorno industrial exigente o en una instalación residencial, nuestra prioridad es cumplir —y superar— las expectativas de nuestros clientes.
                        </p>
                    </div>
                    <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-8">
                        {servicios.map((servicios, index) => (
                            <Card key={index} className="flex flex-col h-full hover:shadow-lg transition-shadow border-t-4 border-t-blue-500">
                                <CardHeader>
                                    <CardTitle className="text-2xl">{servicios.title}</CardTitle>
                                </CardHeader>
                                <CardContent className="flex flex-col flex-grow">
                                    <CardDescription className="text-lg">{servicios.description}</CardDescription>

                                    <ul className="space-y-2">
                                        {servicios.features.map((feature, idx) => (
                                            <li key={idx} className="flex items-center gap-2 text-lg text-gray-600">
                                                <div className="w-2 h-2 bg-blue-500 rounded-full"></div>
                                                {feature}
                                            </li>
                                        ))}
                                    </ul>

                                    <div className="mt-auto pt-4">
                                        <Button className="w-full bg-transparent" onClick={onScrollToForm} variant="outline">
                                            Más Información
                                        </Button>
                                    </div>
                                </CardContent>
                            </Card>
                        ))}
                    </div>
                </div>
            </section>
        </>
    )
}
