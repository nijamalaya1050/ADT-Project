I developed an Abstract Data Type (ADT) to simulate and manage turns within a dynamic group of participants, similar to what you'd see in a board game or shared computing environment. I used an array-based list to keep track of the order, making it easier to loop through turns in a predictable and controlled way.

I also created a separate ADT to represent each person, where each participant has a name to identify them. These person objects are stored within the main turn-tracking ADT. Keeping them separate helped me organize my code and made it easier to manage the data.

The system I built can handle adding and removing participants, showing who’s next, and listing everyone in the current order starting from the next person in line. One of the key things I made sure of was that turn order stays consistent—even when new people join. I set it up so the first new person gets their turn after everyone else, and each person after that goes right after the last new addition. This keeps the process fair and realistic.

I brought everything together with a Client class that acts as the user interface. It lets the user add, drop, list participants, move to the next turn, or end the simulation using keyboard input. This class helped me test everything thoroughly and made the whole program interactive. I also included a way to start with a preset list of participants to make testing easier.

Through this project, I learned how to build a clean, modular, and flexible turn-based system using ADTs. I gained a solid understanding of how to manage fairness, handle dynamic data, and create a real-world simulation using object-oriented programming principles.
