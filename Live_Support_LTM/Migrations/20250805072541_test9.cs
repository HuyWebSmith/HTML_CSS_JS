using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Live_Support_LTM.Migrations
{
    /// <inheritdoc />
    public partial class test9 : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_AspNetUsers_Tickets_TicketId",
                table: "AspNetUsers");

            migrationBuilder.DropForeignKey(
                name: "FK_AspNetUsers_Tickets_TicketId1",
                table: "AspNetUsers");

            migrationBuilder.DropIndex(
                name: "IX_AspNetUsers_TicketId",
                table: "AspNetUsers");

            migrationBuilder.DropIndex(
                name: "IX_AspNetUsers_TicketId1",
                table: "AspNetUsers");

            migrationBuilder.DropColumn(
                name: "TicketId",
                table: "AspNetUsers");

            migrationBuilder.DropColumn(
                name: "TicketId1",
                table: "AspNetUsers");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "TicketId",
                table: "AspNetUsers",
                type: "int",
                nullable: true);

            migrationBuilder.AddColumn<int>(
                name: "TicketId1",
                table: "AspNetUsers",
                type: "int",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_AspNetUsers_TicketId",
                table: "AspNetUsers",
                column: "TicketId");

            migrationBuilder.CreateIndex(
                name: "IX_AspNetUsers_TicketId1",
                table: "AspNetUsers",
                column: "TicketId1");

            migrationBuilder.AddForeignKey(
                name: "FK_AspNetUsers_Tickets_TicketId",
                table: "AspNetUsers",
                column: "TicketId",
                principalTable: "Tickets",
                principalColumn: "Id");

            migrationBuilder.AddForeignKey(
                name: "FK_AspNetUsers_Tickets_TicketId1",
                table: "AspNetUsers",
                column: "TicketId1",
                principalTable: "Tickets",
                principalColumn: "Id");
        }
    }
}
