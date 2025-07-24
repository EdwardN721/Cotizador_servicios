"use client"

import {useState, useEffect, forwardRef} from "react"
import {Button} from "@/components/ui/Button.jsx"
import {Card, CardContent, CardDescription, CardHeader, CardTitle} from "@/components/ui/Card.jsx"
import {AlertCircle, Mail, Phone, MapPin, Send, CheckCircle} from "lucide-react"
import SelectMultiple from "@/components/ui/SelectMultiple.jsx"

const Formulario = forwardRef((props, ref) => {
    // Validar formulario
    const [formData, setFormData] = useState({
        nombre: "",
        asunto: "",
        correo: "",
        servicios: [],
        mensaje: "",
    });

    const [validos, setValidos] = useState({
        nombre: false,
        asunto: false,
        correo: false,
        servicios: false
    });

    const [errors, setErrors] = useState({
        nombre: false,
        asunto: false,
        correo: false,
        servicios: false
    });

    const [tocado, setTocado] = useState({
        nombre: false,
        asunto: false,
        correo: false,
        servicios: false
    });


    const validarCampo = (nombre, valor) => {
        switch (nombre) {
            case "nombre":
                return valor.trim().length >= 10;
            case "asunto":
                return valor.trim().length >= 5;
            case "correo":
                return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(valor.trim());
            case "servicios":
                return Array.isArray(valor) && valor.length > 0;
            default:
                return false;
        }
    };

    const validarFormulario = () => {
        const nuevosErrores = {
            nombre: !validarCampo("nombre", formData.nombre),
            asunto: !validarCampo("asunto", formData.asunto),
            correo: !validarCampo("correo", formData.correo),
            servicios: !validarCampo("servicios", formData.servicios)
        };
        setErrors(nuevosErrores);
        return !Object.values(nuevosErrores).some(Boolean);
    };

    const handleChange = (e) => {
        const {name, value} = e.target;

        setFormData((prev) => ({...prev, [name]: value}));
        setErrors((prev) => ({...prev, [name]: false}));
        setTocado((prev) => ({...prev, [name]: true}));

        setValidos((prev) => ({
            ...prev,
            [name]: validarCampo(name, value)
        }));
    };


    const handleSubmit = async (e) => {
        e.preventDefault();
        if (validarFormulario()) {
            try {
                const response = await fetch("http://localhost:8080/api/correo", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(formData)
                });
                console.log(response);
                if (response.ok) {
                    console.log("Form submitted:", formData);
                    alert("Mensaje enviado correctamente!");
                } else {
                    alert("Hubo un error al enviar el formulario.");
                }
            } catch (error) {
                console.error("Error al enviar:", error);
                alert("Error de conexión con el servidor.");
            }

        }
    };

    useEffect(() => {
        if (!Array.isArray(formData.servicios)) {
            setFormData((prev) => ({...prev, servicios: []}));
        }
    }, []);

    useEffect(() => {
        setValidos({
            nombre: validarCampo("nombre", formData.nombre),
            asunto: validarCampo("asunto", formData.asunto),
            correo: validarCampo("correo", formData.correo),
            servicios: validarCampo("servicios", formData.servicios)
        });
    }, [formData]);

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
                                <Mail className="w-5 h-5 text-blue-600"/>
                                <span>info@tuempresa.com</span>
                            </div>
                            <div className="flex items-center gap-3">
                                <Phone className="w-5 h-5 text-blue-600"/>
                                <span>+1 (555) 123-4567</span>
                            </div>
                            <div className="flex items-center gap-3">
                                <MapPin className="w-5 h-5 text-blue-600"/>
                                <span>123 Calle Principal, Ciudad, País</span>
                            </div>
                        </div>
                    </div>

                    <div ref={ref}>
                        <Card>
                            <CardHeader>
                                <CardTitle className="text-3xl">Solicita una Cotización</CardTitle>
                                <CardDescription>
                                    Completa el formulario y nos pondremos en contacto contigo en menos de 24 horas
                                </CardDescription>
                            </CardHeader>
                            <CardContent>
                                <form onSubmit={handleSubmit} className="space-y-4">
                                    <div className="grid grid-cols-1 gap-4">
                                        <div>
                                            <label htmlFor="nombre" className="block text-sm font-medium mb-1">
                                                Nombre
                                            </label>
                                            <input
                                                id="nombre"
                                                name="nombre"
                                                required
                                                value={formData.nombre}
                                                placeholder="Tú nombre completo"
                                                onChange={handleChange}
                                                className={`w-full p-2 rounded-md transition outline-none
                                            ${
                                                    !tocado.nombre
                                                        ? "border border-gray-300 bg-white"
                                                        : validos.nombre
                                                            ? "border border-green-500 bg-green-50 text-green-700 placeholder-green-400"
                                                            : "border border-red-500 bg-red-50 text-red-700 placeholder-red-400"}`}

                                            />
                                            {tocado.nombre && (
                                                validos.nombre ? (
                                                    <p className="flex items-center text-green-600 text-sm mt-1">
                                                        <CheckCircle className="w-4 h-4 mr-1"/>
                                                        ¡Correcto!
                                                    </p>
                                                ) : (
                                                    <p className="flex items-center text-red-500 text-sm mt-1">
                                                        <AlertCircle className="w-4 h-4 mr-1"/>
                                                        Este campo requiere al menos 10 caracteres
                                                    </p>
                                                )
                                            )}
                                        </div>
                                        <div>
                                            <label htmlFor="asunto" className="block text-sm font-medium mb-1">
                                                Asunto
                                            </label>
                                            <input
                                                id="asunto"
                                                name="asunto"
                                                value={formData.asunto}
                                                placeholder="Personaliza el asunto"
                                                onChange={handleChange}
                                                required
                                                className={`w-full p-2 rounded-md transition outline-none
                                            ${
                                                    !tocado.asunto
                                                        ? "border border-gray-300 bg-white"
                                                        : validos.asunto
                                                            ? "border border-green-500 bg-green-50 text-green-700 placeholder-green-400"
                                                            : "border border-red-500 bg-red-50 text-red-700 placeholder-red-400"}`}

                                            />
                                            {tocado.asunto && (
                                                validos.asunto ? (
                                                    <p className="flex items-center text-green-600 text-sm mt-1">
                                                        <CheckCircle className="w-4 h-4 mr-1"/>
                                                        ¡Correcto!
                                                    </p>
                                                ) : (
                                                    <p className="flex items-center text-red-500 text-sm mt-1">
                                                        <AlertCircle className="w-4 h-4 mr-1"/>
                                                        Este campo requiere al menos 5 caracteres
                                                    </p>
                                                )
                                            )}
                                        </div>
                                        <div>
                                            <label htmlFor="correo" className="block text-sm font-medium mb-1">
                                                correo
                                            </label>
                                            <input
                                                id="correo"
                                                name="correo"
                                                type="correo"
                                                required
                                                placeholder="Correo electrónico"
                                                value={formData.correo}
                                                onChange={handleChange}
                                                className={`w-full p-2 rounded-md transition outline-none
                                            ${
                                                    !tocado.correo
                                                        ? "border border-gray-300 bg-white"
                                                        : validos.correo
                                                            ? "border border-green-500 bg-green-50 text-green-700 placeholder-green-400"
                                                            : "border border-red-500 bg-red-50 text-red-700 placeholder-red-400"}`}

                                            />
                                            {tocado.correo && (
                                                validos.correo ? (
                                                    <p className="flex items-center text-green-600 text-sm mt-1">
                                                        <CheckCircle className="w-4 h-4 mr-1"/>
                                                        ¡Correcto!
                                                    </p>
                                                ) : (
                                                    <p className="flex items-center text-red-500 text-sm mt-1">
                                                        <AlertCircle className="w-4 h-4 mr-1"/>
                                                        Ingresa una dirección de correo electrónico válida!.
                                                    </p>
                                                )
                                            )}
                                        </div>
                                    </div>

                                    <div>
                                        <label htmlFor="service" className="block text-sm font-medium mb-1">
                                            Servicio de Interés
                                        </label>
                                        <SelectMultiple
                                            selected={formData.servicios}
                                            setSelected={(servicios) => setFormData({...formData, servicios})}
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
                                                setFormData({...formData, mensaje: e.target.value})
                                            }
                                            rows={4}
                                            placeholder="Envíanos un comentario..."
                                            className="w-full p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-500 focus:border-transparent resize-vertical"
                                        />
                                    </div>

                                    <Button type="submit" className="w-full">
                                        <Send className="w-4 h-4 mr-2"/>
                                        Enviar Mensaje
                                    </Button>
                                </form>
                            </CardContent>
                        </Card>
                    </div>
                </div>
            </div>
        </section>
    );
});

export default Formulario;