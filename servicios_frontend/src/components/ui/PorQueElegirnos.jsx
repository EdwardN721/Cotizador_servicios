import React from "react";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/Card.jsx";

export default function PorQueElegirnos() {
    return (
        <>
            <section className="py-16 px-4">
                <div className="container mx-auto max-w-6xl">
                    <div className="text-center mb-12">
                        <h2 className="text-4xl font-bold mb-6">Nuestras Ventajas Competitivas</h2>
                        <p className="text-2xl">Porque somos una empresa comprometida con la excelencia, la seguridad y la solución efectiva de cada necesidad industrial o residencial. Nuestro crecimiento sostenido y la confianza de clientes como Procter & Gamble respaldan la calidad de nuestro trabajo. </p>
                    </div>
                    <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-8">
                        {[
                            {
                                title: "Experiencia Comprobada",
                                description: "Desde 2020, hemos ejecutado con éxito proyectos en diversos sectores, cumpliendo con altos estándares y requisitos técnicos.",
                                stat: "2020+",
                            },
                            {
                                title: "Personal capacitado y certificado",
                                description: "Contamos con técnicos especializados en soldadura, electricidad, automatización, trabajos en altura, espacios confinados y más, bajo las normas oficiales mexicanas (nom y stps).",
                                stat: "100%",
                            },
                            {
                                title: "Servicios integrales en un solo lugar",
                                description: "Ofrecemos soluciones completas en mantenimiento, instalaciones eléctricas, hidráulicas, trabajos civiles, pailería, plomería y más, lo que ahorra tiempo, costos y garantiza una mejor coordinación.",
                                stat: "100%",
                            },
                            {
                                title: "Compromiso con la seguridad",
                                description: "Aplicamos protocolos estrictos para proteger tanto al personal como a tus instalaciones, especialmente en trabajos de alto riesgo.",
                                stat: "24/7",
                            },
                            {
                                title: "Atención personalizada y flexibilidad",
                                description: "Nos adaptamos a tus necesidades específicas, con soluciones a la medida, asesoría técnica y acompañamiento en cada etapa del proyecto.",
                                stat: "24/7",
                            },
                            {
                                title: "Enfoque en mejora continua",
                                description: "Invertimos en capacitación, tecnología y procesos para ofrecer siempre un mejor servicio, manteniéndonos a la vanguardia del sector.",
                                stat: "24/7",
                            },
                        ].map((ventaja, index) => (
                            <Card key={index} className="text-center hover:shadow-lg transition-shadow">
                                <CardHeader>
                                    <div className="text-3xl font-bold text-blue-600 mb-2">{ventaja.stat}</div>
                                    <CardTitle className="text-lg">{ventaja.title}</CardTitle>
                                </CardHeader>
                                <CardContent>
                                    <p className="text-gray-600 text-sm">{ventaja.description}</p>
                                </CardContent>
                            </Card>
                        ))}
                    </div>
                </div>
            </section>
        </>
    );
}