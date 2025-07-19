"use client"

import { useState } from "react"
import { Button } from "@/components/ui/Button.jsx"
import { Card } from "@/components/ui/Card.jsx"
import { ChevronLeft, ChevronRight } from "lucide-react"

const portfolio = [
    {
        title: "E-commerce Moderno",
        description: "Plataforma de comercio electrónico con integración de pagos y gestión de inventario.",
        category: "Desarrollo Web",
        image: "/placeholder.svg?height=300&width=400",
    },
    {
        title: "App de Delivery",
        description: "Aplicación móvil para pedidos de comida con tracking en tiempo real.",
        category: "App Móvil",
        image: "/placeholder.svg?height=300&width=400",
    },
    {
        title: "Sistema CRM",
        description: "Sistema de gestión de relaciones con clientes para empresa de servicios.",
        category: "Software Empresarial",
        image: "/placeholder.svg?height=300&width=400",
    },
]

export default function Carrusel() {
    const [currentSlide, setCurrentSlide] = useState(0)

    const nextSlide = () => {
        setCurrentSlide((prev) => (prev + 1) % portfolio.length)
    }

    const prevSlide = () => {
        setCurrentSlide((prev) => (prev - 1 + portfolio.length) % portfolio.length)
    }

    return (
        <section className="py-16 px-4 bg-gray-50">
            <div className="container mx-auto max-w-6xl">
                <div className="text-center mb-12">
                    <h2 className="text-4xl font-bold mb-6">Proyectos Realizados</h2>
                    <p className="text-lg text-gray-600 max-w-3xl mx-auto">
                        Algunos de nuestros trabajos más destacados que demuestran nuestra experiencia y calidad
                    </p>
                </div>

                <div className="relative">
                    <div className="overflow-hidden rounded-lg">
                        <div
                            className="flex transition-transform duration-300 ease-in-out"
                            style={{ transform: `translateX(-${currentSlide * 100}%)` }}
                        >
                            {portfolio.map((project, index) => (
                                <div key={index} className="w-full flex-shrink-0">
                                    <Card className="mx-4">
                                        <div className="grid md:grid-cols-2 gap-6">
                                            <div className="relative h-64 md:h-full">
                                                <img
                                                    src={project.image || "/placeholder.svg"}
                                                    alt={project.title}
                                                    className="w-full h-full object-cover rounded-l-lg"
                                                />
                                            </div>
                                            <div className="p-6 flex flex-col justify-center">
                        <span className="inline-block bg-blue-100 text-blue-800 text-xs px-2 py-1 rounded-full mb-4 w-fit">
                          {project.category}
                        </span>
                                                <h3 className="text-2xl font-bold mb-4">{project.title}</h3>
                                                <p className="text-gray-600 mb-6">{project.description}</p>
                                                <Button className="w-fit">Ver Caso de Estudio</Button>
                                            </div>
                                        </div>
                                    </Card>
                                </div>
                            ))}
                        </div>
                    </div>

                    <Button
                        variant="outline"
                        size="icon"
                        className="absolute left-4 top-1/2 transform -translate-y-1/2 bg-white shadow-lg"
                        onClick={prevSlide}
                    >
                        <ChevronLeft className="w-4 h-4" />
                    </Button>
                    <Button
                        variant="outline"
                        size="icon"
                        className="absolute right-4 top-1/2 transform -translate-y-1/2 bg-white shadow-lg"
                        onClick={nextSlide}
                    >
                        <ChevronRight className="w-4 h-4" />
                    </Button>

                    <div className="flex justify-center mt-6 space-x-2">
                        {portfolio.map((_, index) => (
                            <button
                                key={index}
                                className={`w-3 h-3 rounded-full transition-colors ${
                                    index === currentSlide ? "bg-blue-600" : "bg-gray-300"
                                }`}
                                onClick={() => setCurrentSlide(index)}
                            />
                        ))}
                    </div>
                </div>
            </div>
        </section>
    )
}
