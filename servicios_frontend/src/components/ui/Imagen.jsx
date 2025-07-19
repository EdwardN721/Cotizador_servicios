import React from "react";

export default function Imagen({ src, alt, className, ...props }) {
    return (
        <img
            src={src}
            alt={alt}
            className={className}
            loading="lazy"
            {...props}
        />
    );
}
