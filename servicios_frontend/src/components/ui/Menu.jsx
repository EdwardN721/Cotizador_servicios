import { ArrowLeft } from "lucide-react"
import { Button } from "@/components/ui/Button.jsx"

export default function Menu() {
    return (
        <>
            <header className="sticky top-0 z-50 w-full border-b bg-white/95 backdrop-blur">
                <div className="container mx-auto max-w-6xl px-4 flex h-16 items-center justify-between">

                    {/* Botón para volver */}
                    <Button variant="ghost" asChild>
                        <a href="/" className="flex items-center gap-2 text-sm sm:text-base">
                            <ArrowLeft className="w-4 h-4" />
                            Volver al Inicio
                        </a>
                    </Button>

                    {/* Logo + nombre */}
                    <div className="flex items-center gap-2 sm:gap-4">
                        <img
                            src="../../../src/assets/images/logo.png"
                            alt="Logo"
                            className="h-10 w-auto sm:h-12 object-contain rounded p-1"
                        />
                        <span className="font-bold text-lg sm:text-xl">SEGAE</span>
                    </div>

                    {/* Botón de contacto */}
                    <Button className="text-sm sm:text-base">Contactar</Button>
                </div>
            </header>

        </>
    )
}
