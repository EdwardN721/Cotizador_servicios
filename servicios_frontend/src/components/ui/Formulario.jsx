"use client"

import { useState } from "react"
import { Button } from "@/components/ui/Button.jsx"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/Card.jsx"
import { Mail, Phone, MapPin, Send } from "lucide-react"

export default function Formulario() {
    const [formData, setFormData] = useState({
        name: "",
        email: "",
        phone: "",
        service: "",
        message: "",
    })

    const handleInputChange = (e) => {
        const { name, value } = e.target
        setFormData((prev) => ({
            ...prev,
            [name]: value,
        }))
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log("Form submitted:", formData)
        // Aquí puedes agregar la lógica para enviar el formulario
        alert("Mensaje enviado correctamente!")
    }

    return (
        <section className="py-16 px-4 bg-gray-50">
            <div className="container mx-auto max-w-6xl">
                <div className="grid md:grid-cols-2 gap-12">
                    <div>
                        <h2 className="text-4xl font-bold mb-6">¿Listo para Comenzar?</h2>
                        <p className="text-lg text-gray-600 mb-8">
                            Cuéntanos sobre tu proyecto y te ayudaremos a encontrar la mejor solución para tu negocio.
                        </p>

                        <div className="space-y-4">
                            <div className="flex items-center gap-3">
                                <Mail className="w-5 h-5 text-blue-600" />
                                <span>info@tuempresa.com</span>
                            </div>
                            <div className="flex items-center gap-3">
                                <Phone className="w-5 h-5 text-blue-600" />
                                <span>+1 (555) 123-4567</span>
                            </div>
                            <div className="flex items-center gap-3">
                                <MapPin className="w-5 h-5 text-blue-600" />
                                <span>123 Calle Principal, Ciudad, País</span>
                            </div>
                        </div>
                    </div>

                    <Card>
                        <CardHeader>
                            <CardTitle>Solicita una Cotización</CardTitle>
                            <CardDescription>
                                Completa el formulario y nos pondremos en contacto contigo en menos de 24 horas
                            </CardDescription>
                        </CardHeader>
                        <CardContent>
                            <form onSubmit={handleSubmit} className="space-y-4">
                                <div className="grid grid-cols-2 gap-4">
                                    <div>
                                        <label htmlFor="name" className="block text-sm font-medium mb-1">
                                            Nombre *
                                        </label>
                                        <input
                                            id="name"
                                            name="name"
                                            value={formData.name}
                                            onChange={handleInputChange}
                                            required
                                            className="w-full p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                                        />
                                    </div>
                                    <div>
                                        <label htmlFor="email" className="block text-sm font-medium mb-1">
                                            Email *
                                        </label>
                                        <input
                                            id="email"
                                            name="email"
                                            type="email"
                                            value={formData.email}
                                            onChange={handleInputChange}
                                            required
                                            className="w-full p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                                        />
                                    </div>
                                </div>

                                <div>
                                    <label htmlFor="phone" className="block text-sm font-medium mb-1">
                                        Teléfono
                                    </label>
                                    <input
                                        id="phone"
                                        name="phone"
                                        value={formData.phone}
                                        onChange={handleInputChange}
                                        className="w-full p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                                    />
                                </div>

                                <div>
                                    <label htmlFor="service" className="block text-sm font-medium mb-1">
                                        Servicio de Interés
                                    </label>
                                    <select
                                        id="service"
                                        name="service"
                                        value={formData.service}
                                        onChange={handleInputChange}
                                        className="w-full p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                                    >
                                        <option value="">Selecciona un servicio</option>
                                        <option value="desarrollo-web">Desarrollo Web</option>
                                        <option value="app-movil">Aplicaciones Móviles</option>
                                        <option value="marketing-digital">Marketing Digital</option>
                                        <option value="consultoria-it">Consultoría IT</option>
                                        <option value="ciberseguridad">Ciberseguridad</option>
                                        <option value="automatizacion">Automatización</option>
                                    </select>
                                </div>

                                <div>
                                    <label htmlFor="message" className="block text-sm font-medium mb-1">
                                        Mensaje *
                                    </label>
                                    <textarea
                                        id="message"
                                        name="message"
                                        value={formData.message}
                                        onChange={handleInputChange}
                                        rows={4}
                                        placeholder="Cuéntanos sobre tu proyecto..."
                                        required
                                        className="w-full p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-transparent resize-vertical"
                                    />
                                </div>

                                <Button type="submit" className="w-full">
                                    <Send className="w-4 h-4 mr-2" />
                                    Enviar Mensaje
                                </Button>
                            </form>
                        </CardContent>
                    </Card>
                </div>
            </div>
        </section>
    )
}
