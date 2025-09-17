using Microsoft.AspNetCore.Mvc.RazorPages;
using Live_Support_LTM.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

namespace Live_Support_LTM.Pages.Customer
{
    public class CreateTicketModel : PageModel
    {
        private readonly SupportContext _context;
        private readonly UserManager<ApplicationUser> _userManager;

        public CreateTicketModel(SupportContext context, UserManager<ApplicationUser> userManager)
        {
            _context = context;
            _userManager = userManager;
        }

        public async Task<IActionResult> OnPostAsync()
        {
            var user = await _userManager.GetUserAsync(User);
            if (user == null) return Unauthorized();

            var ticket = new Ticket
            {
                Subject = "Hỗ trợ mới",
                CustomerId = user.Id,
                CreatedAt = DateTime.Now
            };
            _context.Tickets.Add(ticket);
            await _context.SaveChangesAsync();

            var room = new ChatRoom
            {
                RoomCode = Guid.NewGuid().ToString().Substring(0, 8),
                Ticket = ticket,
                CustomerId = user.Id,
                CreatedAt = DateTime.Now
            };
            _context.ChatRooms.Add(room);
            await _context.SaveChangesAsync();

            return RedirectToPage("ChatRoom", new { id = room.Id });
        }
    }
}