"use client"

import { useState, useEffect } from "react"
import { Button } from "@/components/ui/Button.jsx"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/Card.jsx"
import {  AlertCircle, Mail, Phone, MapPin, Send } from "lucide-react"
import SelectMultiple from "@/components/ui/SelectMultiple.jsx"

export default function Formulario() {
    // Validar formulario
    const [formData, setFormData] = useState({
        nombre: "",
        email: "",
        servicios: [], // múltiple
        mensaje: ""
    })

    const [errors, setErrors] = useState({
        nombre: false,
        email: false,
        servicios: false
    })


    const validarFormulario = () => {
        const nuevosErrores = {
            nombre: formData.nombre.trim() === "",
            email: formData.email.trim() === "",
            servicios: formData.servicios.length === 0
        }
        setErrors(nuevosErrores)
        return !Object.values(nuevosErrores).some((error) => error)
    }

    useEffect(() => {
        if (!Array.isArray(formData.servicios)) {
            setFormData({ ...formData, servicios: [] });
        }
    }, []);


    /*
        const handleInputChange = (e) => {
            const {options} = e.target;
            const selectedValues = [];
            for (let i = 0; i < options.length; i++) {
                if (options[i].selected) {
                    selectedValues.push(options[i].value);
                }
            }
            setFormData({...formData, service: selectedValues});
        };
    */

    const handleSubmit = (e) => {
        e.preventDefault()
        if (validarFormulario()) {
            console.log("Form submitted:", formData)
            // Aquí puedes agregar la lógica para enviar el formulario
            alert("Mensaje enviado correctamente!")
        }
    }

    return (
        <section className="py-16 px-4 bg-gray-50">
            <div className="container mx-auto max-w-6xl">
                <div className="grid md:grid-cols-2 gap-12">
                    <div>
                        <h2 className="text-4xl font-bold mb-6">Contacto</h2>
                        <p className="text-lg text-gray-600 mb-8">
                            Si deseas más detalles, no dudes en contactarnos:
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
                                            placeholder="Tú Nombre completo"
                                            onChange={(e) =>
                                                setFormData({ ...formData, nombre: e.target.value })
                                            }
                                            className={`w-full p-2 border rounded-md transition-all duration-300 ${
                                                errors.nombre ? "border-red-500 bg-red-50" : "border-gray-300"
                                            }`}
                                        />
                                        {errors.nombre && (
                                            <p className="text-red-500 text-sm mt-1 flex items-center">
                                                <AlertCircle className="w-4 h-4 mr-1 text-red-500" />
                                                Campo requerido
                                            </p>
                                        )}
                                    </div>
                                    <div>
                                        <label htmlFor="email" className="block text-sm font-medium mb-1">
                                            Email *
                                        </label>
                                        <input
                                            id="email"
                                            name="email"
                                            type="email"
                                            placeholder="Correo electrónico"
                                            value={formData.email}
                                            onChange={(e) =>
                                                setFormData({ ...formData, email: e.target.value })
                                            }
                                            className={`w-full p-2 border rounded-md transition-all duration-300 ${
                                                errors.email ? "border-red-500 bg-red-50" : "border-gray-300"
                                            }`}
                                        />
                                        {errors.email && (
                                            <p className="text-red-500 text-sm mt-1 flex items-center">
                                                <AlertCircle className="w-4 h-4 mr-1 text-red-500" />
                                                Campo requerido
                                            </p>
                                        )}
                                    </div>
                                </div>

                                <div>
                                    <label htmlFor="service" className="block text-sm font-medium mb-1">
                                        Servicio de Interés
                                    </label>
                                    <SelectMultiple
                                        selected={formData.servicios}
                                        setSelected={(servicios) => setFormData({ ...formData, servicios })}
                                        error={errors.servicios}
                                    />
                                </div>

                                <div>
                                    <label htmlFor="mensaje" className="block text-sm font-medium mb-1">
                                        Mensaje
                                    </label>
                                    <textarea
                                        id="mensaje"
                                        name="mensaje"
                                        value={formData.mensaje}
                                        onChange={(e) =>
                                            setFormData({ ...formData, mensaje: e.target.value })
                                        }
                                        rows={4}
                                        placeholder="Envíanos un comentario..."
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
