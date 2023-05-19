package controllers;

import dtos.IssueTicketRequestDto;
import dtos.IssueTicketResponseDto;
import dtos.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto request){

        Ticket ticket;
        IssueTicketResponseDto response=new IssueTicketResponseDto();
        try{
            ticket=ticketService.issueTicket(request.getVehicleType(), request.getVehicleNumber(), request.getOwnerName(), request.getGateId());

        }catch(Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureReason(e.getMessage());
            return response;
        }
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicket(ticket);

        return response;

    }
}
