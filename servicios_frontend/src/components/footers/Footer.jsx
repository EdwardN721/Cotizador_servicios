import React from "react";
import { Separator } from "@/components/ui/Separator.jsx"
import { Button } from "@/components/ui/Button.jsx"
import { Mail, Phone, MapPin } from "lucide-react"

export default function Footer() {
    return (
        <>
            <footer className="py-12 px-4 bg-gray-900 text-white">
                <div className="container mx-auto max-w-6xl">
                    <div className="grid md:grid-cols-3 gap-8">
                        <div>
                            <img
                                src="../../../src/assets/images/logo.png"
                                alt="Logo"
                                className="mb-4 bg-white/10 rounded p-2"
                            />
                            <p className="text-gray-300">Comprometidos con la excelencia y la innovación en cada proyecto.</p>
                        </div>
                        <div>
                            <h3 className="text-xl font-semibold mb-4">Contacto</h3>
                            <div className="space-y-2">
                                <div className="flex items-center gap-2">
                                    <Mail className="w-4 h-4" />
                                    <span>info@empresa.com</span>
                                </div>
                                <div className="flex items-center gap-2">
                                    <Phone className="w-4 h-4" />
                                    <span>+1 (555) 123-4567</span>
                                </div>
                                <div className="flex items-center gap-2">
                                    <MapPin className="w-4 h-4" />
                                    <span>123 Calle Principal, Ciudad</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <h3 className="text-xl font-semibold mb-4">Navegación</h3>
                            <div className="space-y-2">
                                <div>
                                    <a href="/" className="text-gray-300 hover:text-white">
                                        Inicio
                                    </a>
                                </div>
                                <div>
                                    <a href="/services" className="text-gray-300 hover:text-white">
                                        Servicios
                                    </a>
                                </div>
                                <div>
                                    <a href="#equipo" className="text-gray-300 hover:text-white">
                                        Equipo
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div>
                            <h3 className="text-xl font-semibold mb-4">Síguenos</h3>
                            <div className="flex gap-4">
                                <Button
                                    variant="outline"
                                    size="sm"
                                    className="text-white border-white hover:bg-white hover:text-gray-900 bg-transparent"
                                >
                                    LinkedIn
                                </Button>
                                <Button
                                    variant="outline"
                                    size="sm"
                                    className="text-white border-white hover:bg-white hover:text-gray-900 bg-transparent"
                                >
                                    Twitter
                                </Button>
                                <Button
                                    variant="outline"
                                    size="sm"
                                    className="text-white border-white hover:bg-white hover:text-gray-900 bg-transparent"
                                >
                                    Facebook
                                </Button>
                            </div>
                        </div>
                    </div>
                    <Separator className="my-8 bg-gray-700" />
                    <div className="text-center text-gray-400">
                        <p>&copy; 2024 Tu Empresa. Todos los derechos reservados.</p>
                    </div>
                </div>
            </footer>
        </>
    );
}