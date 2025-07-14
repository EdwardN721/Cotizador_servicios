package aurora.servicios.servicios_backend.application.command.solicitudes.handlers;

import aurora.servicios.servicios_backend.application.command.solicitudes.ActualizarSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.solicitudes.CrearSolicitudCommand;
import aurora.servicios.servicios_backend.application.command.solicitudes.EliminarSolicitudCommand;
import aurora.servicios.servicios_backend.dtos.SolicitudesDto;
import aurora.servicios.servicios_backend.models.*;
import aurora.servicios.servicios_backend.repository.spring.JpaClientesRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaEstadosSolicitudRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaServiciosRepository;
import aurora.servicios.servicios_backend.repository.spring.JpaUsuariosRepository;
import aurora.servicios.servicios_backend.services.interfaces.command.SolicitudesCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SolicitudesCommandHandler {
    private final SolicitudesCommandService service;
    private final JpaClientesRepository  clientesRepository;
    private final JpaServiciosRepository serviciosRepository;
    private final JpaEstadosSolicitudRepository estadosSolicitudRepository;
    private final JpaUsuariosRepository usuariosRepository;

    @Autowired
    public SolicitudesCommandHandler (SolicitudesCommandService service, JpaClientesRepository clientesRepository, JpaServiciosRepository serviciosRepository, JpaUsuariosRepository usuariosRepository, JpaEstadosSolicitudRepository estadosSolicitudRepository) {
        this.service = service;
        this.clientesRepository = clientesRepository;
        this.serviciosRepository = serviciosRepository;
        this.usuariosRepository = usuariosRepository;
        this.estadosSolicitudRepository = estadosSolicitudRepository;
    }

    public SolicitudesDto crearSolicitud (CrearSolicitudCommand command){
        Clientes cliente = clientesRepository.findById(command.cliente())
                .orElseThrow(() -> new RuntimeException("El cliente no existe con el ID: " + command.cliente()));
        Servicios servicio = serviciosRepository.findById(command.servicio())
                .orElseThrow(() -> new RuntimeException("El servicio no existe con el ID: " + command.servicio()));
        EstadosSolicitud estado = estadosSolicitudRepository.findById(command.estado())
                .orElseThrow(() -> new RuntimeException("El estado no existe con el ID: " + command.servicio()));
        Usuarios usuario = usuariosRepository.findById(command.usuarioAsignado())
                .orElseThrow(() -> new RuntimeException("El usuario no existe con el ID: " + command.servicio()));

        Solicitudes solicitud = new Solicitudes(command.numeroSolicitud(), cliente, servicio, command.servicioPersonalizado(), command.descripcion(), command.presupuestoEstimado(),
                command.prioridad(), command.fechaSolicitud(), command.fechaEstimacion(), command.fechaInicio(), command.fechaCierre(), estado, usuario, command.origen(), command.notasInternas(), command.notasClientes());
        return service.crearSolicitud(solicitud);
    }

    public SolicitudesDto actualizarSolicitud (ActualizarSolicitudCommand command){
        Clientes cliente = clientesRepository.findById(command.cliente())
                .orElseThrow(() -> new RuntimeException("El cliente no existe con el ID: " + command.cliente()));
        Servicios servicio = serviciosRepository.findById(command.servicio())
                .orElseThrow(() -> new RuntimeException("El servicio no existe con el ID: " + command.servicio()));
        EstadosSolicitud estado = estadosSolicitudRepository.findById(command.estado())
                .orElseThrow(() -> new RuntimeException("El estado no existe con el ID: " + command.servicio()));
        Usuarios usuario = usuariosRepository.findById(command.usuarioAsignado())
                .orElseThrow(() -> new RuntimeException("El usuario no existe con el ID: " + command.servicio()));

        Solicitudes solicitud = new Solicitudes(command.id(), command.numeroSolicitud(), cliente, servicio, command.servicioPersonalizado(), command.descripcion(), command.presupuestoEstimado(),
                command.prioridad(), command.fechaSolicitud(), command.fechaEstimacion(), command.fechaInicio(), command.fechaCierre(), estado, usuario, command.origen(), command.notasInternas(), command.notasClientes());
        return  service.actualizarSolicitud(solicitud);
    }

    public void eliminarSolicitud (EliminarSolicitudCommand command){
        service.eliminarSolicitud(command.id());
    }
}
