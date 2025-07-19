import { ArrowLeft } from "lucide-react"
import { Button } from "@/components/ui/Button.jsx"

export default function Menu() {
    return (
        <>
            <header className="sticky top-0 z-50 w-full border-b bg-white/95 backdrop-blur">
                <div className="container mx-auto max-w-6xl px-4 flex h-16 items-center justify-between">
                    <Button variant="ghost" asChild>
                        <a href="/" className="flex items-center gap-2">
                            <ArrowLeft className="w-4 h-4" />
                            Volver al Inicio
                        </a>
                    </Button>
                    <div className="flex items-center space-x-2">
                        <img src="/placeholder.svg?height=40&width=40" alt="Logo" className="bg-blue-600 rounded p-1" />
                        <span className="font-bold text-xl">Tu Empresa</span>
                    </div>
                    <Button>Contactar</Button>
                </div>
            </header>
        </>
    )
}
