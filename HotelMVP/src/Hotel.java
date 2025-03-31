import java.time.LocalDate;

public class Hotel {
    private final String name;
    private final Room[] rooms;
    private final Reservation[] reservations;
    private int reservationCount = 0;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
        this.reservations = new Reservation[100];
    }

    public Reservation makeReservation(Guest guest, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        final Room room = getRoom(roomNumber);
        if (getRoom(roomNumber) == null) return null;
        if ((isInvalidDateRange(checkIn, checkOut))) return null;
        if (!isAvaliableAt(room, checkIn, checkOut)) return null;

        final Reservation reservation = new Reservation(checkIn, checkOut, guest, room);
        reservations[reservationCount++] = reservation;

        return reservation;
    }

    public Reservation cancelReservation(String reservationId) {
        for (int i = 0; i < reservationCount; i++) {
            Reservation reservation = reservations[i];
            if (reservation.getId().equals(reservationId)) {
                reservations[i] = null;
                return reservation;
            }
        }
        return null;
    }

    private boolean isInvalidDateRange(LocalDate checkIn, LocalDate checkOut) {
        return (checkIn == null || checkOut == null || !checkIn.isBefore(checkOut));
    }

    private Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) return room;
        }
        return null;
    }

    public boolean isAvaliableAt(Room room, LocalDate checkIn, LocalDate checkOut) {
        final boolean hasRoom = hasRoom(room);
        if (!hasRoom) return false;

        for (int i = 0; i < reservationCount; i++){
            Reservation reservation = reservations[i];
            if (reservation != null && reservation.getRoom() == room.getNumber()){
                if (isReservedInRange(room, checkIn, checkOut, reservation)) return false;
            }
        }

        return true;
    }

    private static boolean isReservedInRange(Room room, LocalDate checkIn, LocalDate checkOut, Reservation reservation) {
        LocalDate current = checkIn;
        while(current.isBefore(checkOut)){
            if (reservation.isReservedAt(current, room)) return true;
            current = current.plusDays(1);
        }
        return false;
    }

    private boolean hasRoom(Room room) {
        for (Room r : rooms) {
            if (r.getNumber() == room.getNumber()) return true;
        }
        return false;
    }

    public Room[] getAvailableRoomsAt(LocalDate date) {
        Room[] reservedRooms = new Room[rooms.length];
        int reservedRoomIndex = 0;

        for (Room room : rooms){
            for (int i = 0; i < reservationCount; i++) {
                Reservation reservation = reservations[i];
                if (reservation == null) continue;
                if (reservation.isReservedAt(date, room)) {
                    reservedRooms[reservedRoomIndex++] = room;
                    break;
                }
            }
        }

        int availableRoomSize = rooms.length - reservedRoomIndex;
        Room[] availableRooms = new Room[availableRoomSize];
        int availableRoomIndex = 0;

        for (Room room : rooms) {
            if (room == null) continue;
            boolean contains = false;
            for (Room reservedRoom : reservedRooms){
                if (room.getNumber() == reservedRoom.getNumber()) {
                    contains = true;
                    break;
                }
            }
            if (!contains) availableRooms[availableRoomIndex++] = room;
        }

        return availableRooms;
    }
}
