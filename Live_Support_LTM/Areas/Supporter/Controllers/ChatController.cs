using Live_Support_LTM.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Security.Claims;

namespace Live_Support_LTM.Areas.Supporter.Controllers
{
    [Area("Supporter")]
    [Authorize(Roles = "Supporter")]
    public class ChatController : Controller
    {
        private readonly SupportContext _context;

        public ChatController(SupportContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            var supporterId = User.FindFirstValue(ClaimTypes.NameIdentifier);
            var tickets = _context.Tickets
      
                .ToList();

            ViewBag.Tickets = tickets;
            return View();
        }

       

        public IActionResult ChatRoom(int ticketId)
        {
            var ticket = _context.Tickets.FirstOrDefault(t => t.Id == ticketId);
            if (ticket == null) return NotFound();

            var supporterId = User.FindFirstValue(ClaimTypes.NameIdentifier);

            if (string.IsNullOrEmpty(ticket.SupporterId))
            {
                ticket.SupporterId = supporterId;
                _context.SaveChanges();
            }
            ViewBag.RoomName = ticket.RoomId;
            return View();
        }


        [HttpPost]
        public async Task<IActionResult> Transfer(int ticketId, string newSupporterId)
        {
            var ticket = await _context.Tickets.FindAsync(ticketId);
            if (ticket != null)
            {
                ticket.SupporterId = newSupporterId;
                await _context.SaveChangesAsync();
            }

            return RedirectToAction("Index");
        }
    }

}
