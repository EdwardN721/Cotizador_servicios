import { Card, CardContent, CardHeader, CardTitle, CardDescription } from "@/components/ui/Card.jsx"
import { Button } from "@/components/ui/Button.jsx"
import { Code, Smartphone, TrendingUp, Shield, Settings, Zap } from "lucide-react"

const services = [
    {
        title: "Desarrollo Web",
        description: "Creamos sitios web modernos y responsivos",
        icon: <Code className="w-8 h-8" />,
        features: ["Diseño responsivo", "SEO optimizado", "Carga rápida", "Seguridad avanzada"],
    },
    {
        title: "Aplicaciones Móviles",
        description: "Apps nativas e híbridas para iOS y Android",
        icon: <Smartphone className="w-8 h-8" />,
        features: ["iOS y Android", "UI/UX intuitivo", "Integración API", "Notificaciones push"],
    },
    {
        title: "Marketing Digital",
        description: "Estrategias para hacer crecer tu negocio online",
        icon: <TrendingUp className="w-8 h-8" />,
        features: ["SEO/SEM", "Redes sociales", "Email marketing", "Analytics"],
    },
    {
        title: "Consultoría IT",
        description: "Asesoramiento tecnológico especializado",
        icon: <Settings className="w-8 h-8" />,
        features: ["Auditoría técnica", "Arquitectura de sistemas", "Migración cloud", "Optimización"],
    },
    {
        title: "Ciberseguridad",
        description: "Protección integral para tu infraestructura",
        icon: <Shield className="w-8 h-8" />,
        features: ["Análisis de vulnerabilidades", "Firewall avanzado", "Backup automático", "Monitoreo 24/7"],
    },
    {
        title: "Automatización",
        description: "Procesos automatizados para mayor eficiencia",
        icon: <Zap className="w-8 h-8" />,
        features: ["Workflows automáticos", "Integración de sistemas", "Reportes automáticos", "Ahorro de tiempo"],
    },
]

export default function Servicios() {
    return (
        <>
            <section className="py-16 px-4">
                <div className="container mx-auto max-w-6xl">
                    <div className="text-center mb-12">
                        <h2 className="text-4xl font-bold mb-6">¿Qué Ofrecemos?</h2>
                        <p className="text-lg text-gray-600 max-w-3xl mx-auto">
                            Brindamos servicios especializados en tecnología para ayudar a tu empresa a crecer y destacar en el
                            mercado digital
                        </p>
                    </div>
                    <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-8">
                        {services.map((service, index) => (
                            <Card key={index} className="hover:shadow-lg transition-shadow border-t-4 border-t-blue-500">
                                <CardHeader>
                                    <div className="text-blue-600 mb-4">{service.icon}</div>
                                    <CardTitle className="text-xl">{service.title}</CardTitle>
                                    <CardDescription>{service.description}</CardDescription>
                                </CardHeader>
                                <CardContent>
                                    <ul className="space-y-2">
                                        {service.features.map((feature, idx) => (
                                            <li key={idx} className="flex items-center gap-2 text-sm text-gray-600">
                                                <div className="w-2 h-2 bg-blue-500 rounded-full"></div>
                                                {feature}
                                            </li>
                                        ))}
                                    </ul>
                                    <Button className="w-full mt-4 bg-transparent" variant="outline">
                                        Más Información
                                    </Button>
                                </CardContent>
                            </Card>
                        ))}
                    </div>
                </div>
            </section>
        </>
    )
}
