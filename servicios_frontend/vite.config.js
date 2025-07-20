import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite'
import path from 'path'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react(),
    tailwindcss(),
  ],
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './src'),
    },
  },
  /*
  server: { //Exponer el HOST
    host: true, // 👈 esto permite aceptar conexiones externas
    port: 5173  // puedes cambiar el puerto si lo deseas
  }*/
})
