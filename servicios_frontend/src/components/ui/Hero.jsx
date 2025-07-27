import {Link} from 'react-router-dom';
import Image from "@/components/ui/Imagen.jsx"

export default function Hero() {
    return (
        <div className="w-full bg-gradient-to-br from-purple-100 via-purple-200 to-blue-200 relative overflow-hidden">
            <div className="absolute inset-0 bg-gradient-to-r from-white/60 via-purple-200/40 to-blue-200/30"></div>

            <div className="relative z-10 max-w-7xl mx-auto px-4 py-12 sm:px-6 lg:px-8">
                <div className="flex flex-col-reverse md:grid md:grid-cols-2 gap-10 items-center text-center md:text-left">
                    <div className="space-y-8">
                        <div className="space-y-6">
                            <h1 className="text-4xl sm:text-5xl lg:text-6xl font-bold text-gray-800 leading-tight">
                                SEGAE
                            </h1>
                            <p className="text-gray-700 text-lg sm:text-xl leading-relaxed max-w-md mx-auto md:mx-0">
                                SERVICIOS GENERALES Y ESPECIALIZADOS A.E
                            </p>
                        </div>
                        <div>
                            <Link to="/servicios">
                                <button className="cursor-pointer bg-amber-300 hover:bg-amber-500 text-gray-900 px-8 py-4 text-lg font-semibold rounded-full shadow-md hover:shadow-lg transition transform hover:scale-105 w-full sm:w-auto">
                                    Ver Nuestros Servicios
                                </button>
                            </Link>
                        </div>
                    </div>

                    <div className="flex justify-center md:justify-end">
                        <div className="relative w-full max-w-xs sm:max-w-sm md:max-w-md">
                            <Image
                                src="../../../src/assets/images/logo.png"
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