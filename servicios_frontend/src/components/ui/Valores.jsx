import React from 'react';
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/Card.jsx";

export default function Valores() {
    return (
        <>
            <section className="py-16 px-4">
                <div className="container mx-auto max-w-6xl">
                    <div className="text-center mb-12">
                        <h2 className="text-4xl font-bold mb-6">Valores</h2>
                    </div>
                    <div className="grid md:grid-cols-3 gap-8">
                        {[
                            {
                                title: "Compromiso con la calidad",
                                description: "Entregamos cada servicio con enfoque en la excelencia, cumpliendo con los más altos estándares técnicos y normativos.",
                                icon: "🤝",
                            },
                            {
                                title: "Seguridad como prioridad",
                                description:
                                    "La integridad de nuestro equipo y de nuestros clientes es lo más importante. Operamos siempre bajo estrictas normas de seguridad industrial, especialmente en trabajos de alto riesgo como espacios confinados y alturas.",
                                icon: "⚠️",
                            },
                            {
                                title: "Responsabilidad",
                                description: "Cumplimos lo que prometemos. Cada proyecto se ejecuta con seriedad, puntualidad y un enfoque ético que genera confianza.",
                                icon: "💡",
                            },
                            {
                                title: "Mejora continua",
                                description: "Creemos en evolucionar constantemente. Invertimos en capacitación, procesos y tecnología para ofrecer soluciones más eficientes, seguras y actualizadas.",
                                icon: "🎯",
                            },
                            {
                                title: "Adaptabilidad",
                                description: "Nos ajustamos a las necesidades cambiantes de nuestros clientes e industrias, manteniendo la flexibilidad como una fortaleza competitiva",
                                icon: "👥",
                            },
                            {
                                title: "Profesionalismo",
                                description: "Nuestro personal técnico está capacitado y certificado para responder con precisión, eficacia y respeto en todo momento.",
                                icon: "💼",
                            },
                        ].map((valor, index) => (
                            <Card key={index} className="text-center hover:shadow-lg transition-shadow">
                                <CardHeader>
                                    <div className="text-4xl mb-4">{valor.icon}</div>
                                    <CardTitle className="text-xl">{valor.title}</CardTitle>
                                </CardHeader>
                                <CardContent>
                                    <p className="text-gray-600">{valor.description}</p>
                                </CardContent>
                            </Card>
                        ))}
                    </div>
                </div>
            </section>
        </>
    )
}