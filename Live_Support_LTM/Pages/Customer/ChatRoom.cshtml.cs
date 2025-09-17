using Microsoft.AspNetCore.Mvc.RazorPages;
using Live_Support_LTM.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

namespace Live_Support_LTM.Pages.Customer
{
    public class ChatRoomModel : PageModel
    {
        private readonly SupportContext _context;
        private readonly UserManager<ApplicationUser> _userManager;

        public string RoomCode { get; set; }
        public string UserName { get; set; }
        public int RoomId { get; set; }

        public ChatRoomModel(SupportContext context, UserManager<ApplicationUser> userManager)
        {
            _context = context;
            _userManager = userManager;
        }

        public async Task<IActionResult> OnGetAsync(int id)
        {
            var room = await _context.ChatRooms.FindAsync(id);
            if (room == null) return NotFound();

            RoomCode = room.RoomCode;
            RoomId = room.Id;
            var user = await _userManager.GetUserAsync(User);
            UserName = user?.FullName ?? "Guest";
            return Page();
        }
    }
}