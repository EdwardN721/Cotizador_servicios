import { useState } from "react"
import { Button } from "@/components/ui/Button.jsx"
import { Card } from "@/components/ui/Card.jsx"
import { ChevronLeft, ChevronRight } from "lucide-react"
import Imagen from "@/components/ui/Imagen.jsx"
import { portfolioServicios } from "../../assets/json/PortafolioJson.json"

export default function Carrusel() {
    const [currentSlide, setCurrentSlide] = useState(0)
    const [currentImagenIndex, setCurrentImagenIndex] = useState({ 0: 0, 1: 0 }) // Para cada servicio

    const nextSlide = () => {
        setCurrentSlide((prev) => (prev + 1) % portfolioServicios.length)
    }

    const prevSlide = () => {
        setCurrentSlide((prev) => (prev - 1 + portfolioServicios.length) % portfolioServicios.length)
    }

    const nextImagen = (servicioIndex) => {
        setCurrentImagenIndex((prev) => ({
            ...prev,
            [servicioIndex]: (prev[servicioIndex] + 1) % portfolioServicios[servicioIndex].imagenes.length,
        }))
    }

    const prevImagen = (servicioIndex) => {
        setCurrentImagenIndex((prev) => ({
            ...prev,
            [servicioIndex]:
                (prev[servicioIndex] - 1 + portfolioServicios[servicioIndex].imagenes.length) %
                portfolioServicios[servicioIndex].imagenes.length,
        }))
    }

    return (
    <section className="py-16 px-4 bg-gray-50">
        <div className="container mx-auto max-w-6xl">
            <div className="text-center mb-12">
                <h2 className="text-4xl font-bold mb-6">Nuestros Servicios en Acción</h2>
                <p className="text-lg text-gray-600 max-w-3xl mx-auto">
                    Descubre algunos de nuestros trabajos más destacados en desarrollo web y aplicaciones móviles
                </p>
            </div>

            <div className="relative">
                <div className="overflow-hidden rounded-lg">
                    <div
                        className="flex transition-transform duration-500 ease-in-out"
                        style={{ transform: `translateX(-${currentSlide * 100}%)` }}
                    >
                        {portfolioServicios.map((servicio, servicioIndex) => (
                            <div key={servicioIndex} className="w-full flex-shrink-0">
                                <Card className="mx-4">
                                    <div className="grid lg:grid-cols-2 gap-8 p-6">
                                        {/* Galería de imágenes */}
                                        <div className="relative">
                                            <div className="aspect-[4/5] w-full max-w-md overflow-hidden bg-gray-100 rounded-lg flex items-center justify-center m-auto">
                                                <Imagen
                                                    src={servicio.imagenes[currentImagenIndex[servicioIndex]].url || "/placeholder.svg"}
                                                    alt={servicio.imagenes[currentImagenIndex[servicioIndex]].titulo}
                                                    className="object-contain w-full h-full"
                                                />


                                            {/* Navegación de imágenes */}
                                                <Button
                                                    variant="outline"
                                                    size="icon"
                                                    className="absolute left-2 top-1/2 transform -translate-y-1/2 bg-white/80 hover:bg-white"
                                                    onClick={() => prevImagen(servicioIndex)}
                                                >
                                                    <ChevronLeft className="w-4 h-4" />
                                                </Button>
                                                <Button
                                                    variant="outline"
                                                    size="icon"
                                                    className="absolute right-2 top-1/2 transform -translate-y-1/2 bg-white/80 hover:bg-white"
                                                    onClick={() => nextImagen(servicioIndex)}
                                                >
                                                    <ChevronRight className="w-4 h-4" />
                                                </Button>

                                                {/* Indicadores de Imagen */}
                                                <div className="absolute bottom-4 left-1/2 transform -translate-x-1/2 flex space-x-2">
                                                    {servicio.imagenes.map((_, imgIndex) => (
                                                        <button
                                                            key={imgIndex}
                                                            className={`w-2 h-2 rounded-full transition-colors ${
                                                                imgIndex === currentImagenIndex[servicioIndex] ? "bg-white" : "bg-white/50"
                                                            }`}
                                                            onClick={() =>
                                                                setCurrentImagenIndex((prev) => ({
                                                                    ...prev,
                                                                    [servicioIndex]: imgIndex,
                                                                }))
                                                            }
                                                        />
                                                    ))}
                                                </div>
                                            </div>

                                            {/* Información de la Imagen actual */}
                                            <div className="mt-4 text-center">
                                                <h4 className="font-semibold text-lg">
                                                    {servicio.imagenes[currentImagenIndex[servicioIndex]].titulo}
                                                </h4>
                                                <p className="text-gray-600 text-sm mt-1">
                                                    {servicio.imagenes[currentImagenIndex[servicioIndex]].descripcion}
                                                </p>
                                            </div>
                                        </div>

                                        {/* Información del servicio */}
                                        <div className="flex flex-col justify-center">
                                            <h3 className="text-3xl font-bold mb-4">{servicio.titulo}</h3>
                                            <p className="text-gray-600 mb-6 text-lg text-justify leading-relaxed mr-4">{servicio.descripcion}</p>
                                            <div className="flex gap-3">
                                                <Button className="flex-1 mt-3">
                                                    Solicitar Cotización
                                                </Button>
                                            </div>
                                        </div>
                                    </div>
                                </Card>
                            </div>
                        ))}
                    </div>
                </div>

                {/* Navegación principal entre servicios */}
                <Button
                    variant="outline"
                    size="icon"
                    className="absolute left-4 top-1/2 transform -translate-y-1/2 bg-white shadow-lg z-10"
                    onClick={prevSlide}
                >
                    <ChevronLeft className="w-4 h-4" />
                </Button>
                <Button
                    variant="outline"
                    size="icon"
                    className="absolute right-4 top-1/2 transform -translate-y-1/2 bg-white shadow-lg z-10"
                    onClick={nextSlide}
                >
                    <ChevronRight className="w-4 h-4" />
                </Button>

                {/* Indicadores de servicio */}
                <div className="flex justify-center mt-8 space-x-3">
                    {portfolioServicios.map((servicio, index) => (
                        <button
                            key={index}
                            className={`px-4 py-2 rounded-full text-sm font-medium transition-colors ${
                                index === currentSlide ? "bg-blue-600 text-white" : "bg-gray-200 text-gray-600 hover:bg-gray-300"
                            }`}
                            onClick={() => setCurrentSlide(index)}
                        >
                            {servicio.titulo}
                        </button>
                    ))}
                </div>
            </div>
        </div>
    </section>
    )
}
