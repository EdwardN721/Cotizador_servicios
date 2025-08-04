import {Link} from 'react-router-dom';
import Image from "@/components/ui/Imagen.jsx"
import logo from "@/assets/images/logo.png"

export default function Hero() {
    return (
        <div className="relative w-full bg-[#1E3A8A] overflow-hidden">
            <div className="absolute inset-0 bg-white/10 mix-blend-overlay"></div>

            <div className="relative z-10 max-w-7xl mx-auto px-4 py-12 sm:px-6 lg:px-8">
                <div className="flex flex-col-reverse md:grid md:grid-cols-2 gap-10 items-center text-center md:text-left">
                    <div className="space-y-8">
                        <div className="space-y-6">
                            <h1 className="text-4xl sm:text-5xl lg:text-6xl font-bold text-white leading-tight">
                                SEGAE
                            </h1>
                            <p className="text-white text-lg sm:text-xl leading-relaxed max-w-md mx-auto md:mx-0">
                                SERVICIOS GENERALES Y ESPECIALIZADOS A.E
                            </p>
                        </div>
                        <div>
                            <Link to="/servicios">
                                <button className="cursor-pointer bg-[#4682B4] hover:bg-[#3D729E] text-white px-8 py-4 text-lg font-semibold rounded-full shadow-md hover:shadow-lg transition transform hover:scale-105 w-full sm:w-auto">
                                    Ver Nuestros Servicios
                                </button>
                            </Link>
                        </div>
                    </div>

                    <div className="flex justify-center md:justify-end">
                        <div className="relative w-full max-w-xs sm:max-w-sm md:max-w-md">
                            <Image
                                src={logo}
                                alt="Logo de la empresa"
                                className="w-8/12 h-auto object-contain m-auto"
                            />
                            <div className="absolute inset-0 bg-gradient-to-r from-transparent via-purple-300/20 to-blue-300/20 rounded-full blur-3xl"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="absolute top-1/3 right-1/4 w-64 h-64 bg-purple-300/10 rounded-full blur-3xl"></div>
            <div className="absolute bottom-1/4 left-1/4 w-48 h-48 bg-blue-300/10 rounded-full blur-2xl"></div>
        </div>
    )
}