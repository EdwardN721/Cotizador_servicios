import React from "react";
import QuienesSomos from "../ui/QuienesSomos.jsx";
import MisionVision from "../ui/MisionVision.jsx";
import Valores from "@/components/ui/Valores.jsx";
import Historia from "@/components/ui/Historia.jsx";
import PorQueElegirnos from "@/components/ui/PorQueElegirnos.jsx";

export default function Main() {
    return (
        <>
            <QuienesSomos />
            <Historia />
            <MisionVision />
            <Valores />
            <PorQueElegirnos />
        </>
    );
}