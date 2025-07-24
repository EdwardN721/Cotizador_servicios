import React, {useRef} from "react";
import Menu from "@/components/ui/Menu.jsx";
import HeroServicios from "@/components/ui/HeroServicios.jsx";
import Carrusel from "@/components/ui/Carrusel.jsx";
import Nosotros from "@/components/ui/Nosotros.jsx";
import Formulario from "@/components/ui/Formulario.jsx";
import Footer from "@/components/footers/Footer.jsx";
import Servicios from "@/components/ui/Servicios.jsx";



export default function ServiciosPage() {
    const formRef = useRef(null);

    const scrollToForm = () => {
        formRef.current?.scrollIntoView({ behavior: 'smooth' });
    };

    return (
        <>
            <Menu onScrollToForm={scrollToForm}/>
            <HeroServicios />
            <Servicios onScrollToForm={scrollToForm} />
            <Carrusel />
            <Nosotros />
            <Formulario ref={formRef} />
            <Footer />
        </>
    );
}