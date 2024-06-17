# CalendarApp
The Calendar Application is a tool that helps users manage and organize their events, schedules, and related information. The key components and their purposes are as follows:

EventType:
This represents the different types of events that can be scheduled, such as Lectures, Workshops, Meetings, and Exams.
Maintaining a separate table for event types allows the application to categorize and filter events based on their type, providing more flexibility and functionality.
Event:
The Event class represents a specific event, with details like title, description, start and end times, associated schedule, and event type.
Storing events in a dedicated table allows the application to manage and retrieve event information efficiently.
Schedule:
The Schedule class represents a collection of events, grouped together for better organization and management.
Schedules can be used to group related events, such as a series of lectures or a conference program.
CalendarApp:
The CalendarApp class is the central hub of the application, responsible for managing the list of events and schedules.
It provides methods to add, assign, and retrieve events based on various criteria, such as date, schedule, or event type.
This class serves as the main entry point for the user to interact with the calendar application.
The design of this calendar application aims to provide the following benefits:

Flexibility: By separating event types, schedules, and events into distinct entities, the application can accommodate a wide range of use cases and event types, making it more versatile and scalable.
Efficient Data Management: The relational database structure, with the EventType, Event, Schedule, and CalendarApp tables, allows for efficient storage, retrieval, and organization of calendar data.
Querying and Filtering: The application can easily retrieve events based on various criteria, such as date, schedule, or event type, by leveraging the database structure and the provided methods in the CalendarApp class.
Relationships and Associations: The associations between events, schedules, and event types (represented by the foreign key relationships) enable the application to maintain the connections between these entities, providing a comprehensive and coherent view of the calendar data.
Extensibility: The design of the calendar application, with its modular components and well-defined responsibilities, makes it easier to extend or modify the application in the future, such as adding new features or integrating with other systems.
