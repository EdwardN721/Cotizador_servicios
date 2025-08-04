import React from "react";
import { Separator } from "@/components/ui/Separator.jsx"
import { Mail, Phone, MapPin  } from "lucide-react"
import { FaInstagram, FaTwitter, FaLinkedin } from "react-icons/fa";
import logo from "@/assets/images/logo.png";

export default function Footer() {
    const social = [
        {
            name: "Instagram",
            icon: <FaInstagram />,
            url: "https://www.instagram.com/segae2020/",
            color: "hover:text-pink-500",
        },
        {
            name: "LinkedIn",
            icon: <FaLinkedin />,
            url: "https://linkedin.com/in/miUsuario2000",
            color: "hover:text-blue-600",
        },
    ];

    return (
        <>
            <footer className="py-10 px-4 bg-gray-900 text-white">
                <div className="container mx-auto max-w-6xl">
                    <div className="grid md:grid-cols-3 gap-8">
                        <div>
                            <img
                                src={logo}
                                alt="Logo"
                                className="h-50 mx-auto mb-4 bg-white/10 rounded p-2"
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
                                    <a href="/servicios" className="text-gray-300 hover:text-white">
                                        Servicios
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div>
                            <h3 className="text-xl font-semibold mb-4">Síguenos</h3>
                            <div className="flex gap-4">
                                {social.map((item) => (
                                    <a
                                        key={item.name}
                                        href={item.url}
                                        target="_blank"
                                        rel="noopener noreferrer"
                                        className={`text-2xl hover:scale-110 transition-transform duration-200
                                          focus:outline-none focus:ring-0 focus:ring-pink-400
                                          rounded ${item.color}`}
                                        aria-label={`Ir a ${item.name}`}
                                    >
                                        {item.icon}
                                    </a>
                                ))}
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