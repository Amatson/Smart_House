# This is UIC coudse Smart House CLI demo

print('Welcome to Smart House!')

# Printing the possible options for user
helptext = 'Here are your command options:\n\n \
    status      Full status of the system \n \
    room        See room status \n \
    lock        Locks all doors \n \
    unlock      Unlocks all doors \n \
    set         Modify system properties \n \
    help        Prints this help text \n \
    q = quit    Exits program \n'
print(helptext)

# Store user input to cmnd variable
cmnd = input('What do you wish to do? \n')

# Start looping. Exit with 'q' or 'quit'
while cmnd != 'q' and cmnd != 'quit':
    print('You choosed ' + cmnd)

    if cmnd == 'status':
        print('Printing status... \n\
Outside: \n\
    Temperature: -4 C \n\
    Humidity: 60% \n\
    Wind: 5 m/s Nortwest \n\
Doors: Locked \n\
Main room: \n\
    Temperature: +22 C \n\
    Humidity: 40% \n')

    elif cmnd == 'room':
        id = input('Give the room index you wish to observe \n')
        print('Status of the room #' + id + ' is: \n \
    Temperature: +25 C \n \
    Humidity: 50%')

    elif cmnd == 'lock':
        print('Locking all doors')

    elif cmnd == 'unlock':
        print('Unlocking all doors')

    elif cmnd == 'set':
        id = input('Give the room index you wish to control, 0 to all rooms at once \n')
        print('Status of the room #' + id + ' is: \n \
    Temperature: +25 C \n \
    Humidity: 50%')
        prop = input('Which property you wish to modify? Here are the options:\n\
    temperature \n\
    humidity \n')
        value = input('Give new value for ' + prop + ' in room #' + id + '\n')
        print('Status of the room #' + id + ' is: \n\
    Temperature: +60 C \n\
    Humidity: 90%')

    elif cmnd == 'help':
        print(helptext)

    else:
        print('Unknown command')

    # At the end of the loop ask user for new input
    cmnd = input('What do you wish to do?' + '\n')

# Termninate program as command was 'q' or 'quit'
print('Terminating program...')
