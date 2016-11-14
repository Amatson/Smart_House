# This is UIC coudse Smart House CLI demo

print('Welcome to Smart House!')


class Room:
    def __init__(self, roomid, name, temperature, humidity):
        self.temperature = temperature
        self.humidity = humidity
        self.name = name
        self.room_id = roomid
        self.lighting = False
        self.smoke_detector_operational = True
        self.smoke_detector_alert = False
        self.air_quality = 50

    def print_status(self):
        print(self.name + ' (' + str(self.room_id) + ')\n'
              '    Temperature: ' + str(self.temperature) + '\n'
              '    Humidity: ' + str(self.humidity) + '\n'
              '    Air quality: ' + str(self.air_quality) + '\n'
              '    Lights: ', 'On\n' if self.lighting else 'Off\n',
              '    Smoke detector operational: ', 'Yes\n' if self.smoke_detector_operational else 'No\n',
              '    Smoke detector alert: ', 'On\n' if self.smoke_detector_alert else 'Off\n', sep='')


class SmartHouse:
    def __init__(self, temperature_out, humidity_out):
        self.temperature_out = temperature_out
        self.humidity_out = humidity_out
        self.wind_speed = 5
        self.wind_direction = 'Southwest'
        self.lighting_out = False
        self.doors_locked = False
        self.rooms = []

    def add_room(self, name, temperature, humidity):
        self.rooms.append(Room(len(self.rooms) + 1, name, temperature, humidity))

    def get_door_status(self):
        return 'Locked' if self.doors_locked else 'Unlocked'

    def get_lighting_status(self):
        return 'On' if self.lighting_out else 'Off'

    def print_room_status(self, roomid):
        roomid = int(roomid)
        if roomid > len(self.rooms):
            print('Room not found.')
        else:
            self.rooms[roomid - 1].print_status()

    def set_room_attribute(self, roomid, attribute, val):
        roomid = int(roomid)
        if roomid > len(self.rooms):
            return
        if attribute == 'temperature':
            self.rooms[roomid - 1].temperature = val
        elif attribute == 'humidity':
            self.rooms[roomid - 1].humidity = val


def help_text():
    print('Here are your command options:\n\n'
          '    status      Full status of the system\n'
          '    room        See room status\n'
          '    lock        Locks all doors\n'
          '    unlock      Unlocks all doors\n'
          '    lights      Modify lighting\n'
          '    set         Modify system properties\n'
          '    help        Prints this help text\n'
          '    q = quit    Exits program\n')


house = SmartHouse(20, 60)
house.add_room('Main room', 21, 40)
house.add_room('Bed room', 20, 45)
house.add_room('Living room', 25, 42)

# Printing the possible options for user
help_text()
cmnd = input('What do you wish to do? \n')
# Start looping. Exit with 'q' or 'quit'
while cmnd != 'q' and cmnd != 'quit':
    print('You chose ' + cmnd)

    if cmnd == 'status':
        print('Printing status... \n'
              'Outside:\n'
              '    Temperature: ' + str(house.temperature_out) + 'C\n'
              '    Humidity: ' + str(house.humidity_out) + '%\n'
              '    Wind: ' + str(house.wind_speed) + ' m/s ' + house.wind_direction + '\n'
              'Doors: ' + house.get_door_status() + '\n'
              'Outside lighting: ' + house.get_lighting_status() + '\n')
        print('Rooms:')
        for room in house.rooms:
            room.print_status()
    elif cmnd == 'room':
        room_id = input('Give the room index you wish to observe\n')
        house.print_room_status(room_id)
    elif cmnd == 'lock':
        print('Locking all doors')
        house.doors_locked = True
    elif cmnd == 'unlock':
        house.doors_locked = False
        print('Unlocking all doors')
    elif cmnd == 'lights':
        lights_type = input('Which lights do you wish to control?\n'
                            '    1 inside\n'
                            '    2 outside\n')
        if lights_type == '1':
            room_id = input('Give the room index you wish to control\n')
            toggle_type = input('On (1) or off (2)?\n')
            if toggle_type == '1':
                print('Room ' + room_id + ': lights are now turned on')
                house.rooms[int(room_id) - 1].lighting = True
            elif toggle_type == '2':
                print('Room ' + room_id + ': lights are now turned off')
                house.rooms[int(room_id) - 1].lighting = False
        elif lights_type == '2':
            toggle_type = input('On (1) or off (2)?\n')
            if toggle_type == '1':
                print('Outside lights are now turned on')
                house.lighting_out = True
            elif toggle_type == '2':
                print('Outside lights are now turned off')
                house.lighting_out = False
    elif cmnd == 'set':
        room_id = input('Give the room index you wish to control\n')
        house.print_room_status(room_id)
        prop_num = input('Input the number of the property you wish to control\n'
                         '    1 temperature\n'
                         '    2 humidity\n')
        properties = {'1': 'temperature', '2': 'humidity'}
        prop_value = input('Give new value for ' + properties[prop_num] + ' in room #' + room_id + '\n')
        house.set_room_attribute(room_id, properties[prop_num], prop_value)
        house.print_room_status(room_id)
    elif cmnd == 'help':
        help_text()
    else:
        print('Unknown command')

    # At the end of the loop ask user for new input
    cmnd = input('What do you wish to do?\n')

# Termninate program as command was 'q' or 'quit'
print('Terminating program...')
