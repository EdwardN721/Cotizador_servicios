import { Button } from "@/components/ui/Button.jsx"
import { Link } from 'react-router-dom';

export default function Hero() {
    return (
        <div className="relative py-20 px-4 text-center ">
            <div className="text-white container mx-auto max-w-6xl">
                <div className="m-5 p-5 w-full h-full flex justify-center items-center">
                    <img
                        src="../../../src/assets/images/logo.png"
                        alt="Logo de la empresa"
                        className="w-3/6 mx-auto mb-6 bg-white/10 rounded-lg p-4"
                    />
                </div>
                <h1 className="text-5xl md:text-6xl font-bold mb-6">SEGAE</h1>
                <p className="text-xl md:text-2xl mb-8 max-w-3xl mx-auto opacity-90">
                    SERVICIOS GENERALES Y ESPECIALIZADOS A.E
                </p>
                <div className="flex flex-col sm:flex-row gap-4 justify-center">


                    <Button
                        size="lg"
                        variant="outline"
                        className="border-white text-white hover:bg-white hover:text-blue-600 bg-transparent"
                    >
                        <Link to="/servicios" className="w-full h-full flex justify-center items-center text-inherit no-underline">
                            Ver Nuestros Servicios
                        </Link>
                    </Button>

                </div>
            </div>
        </div>
    )
}
