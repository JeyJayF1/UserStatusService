# UserStatusService
Der UserStatusService wird genutzt um den Status eines gegebenen Users auf Online/Offline zu stellen. Bei der Erzeugung eines neuen Users wird dessen Status automatisch auf Online gestellt. Ebenfalls ist der Status manuell änderbar.

## UserStatus ändern
Die Methode `checkStatus(UUID id)` dient dazu den Status eines gegeben Users über die UUID zuzustellen. Dabei ist der gelieferte Output vom Datentyp ``Mono<UserStatusContainer>``. Diese Methode nutzt die Methode 
`getUser(UUID id)` um den richtigen User zu finden.

Die Methoden `setOnline(User user)` und `setOffline(User user)` dienen dazu den Status eines Users manuell zu wechseln. Dabei werden die Methoden `Online()` und `Offline()` aufgerufen um den UserStatusContainer zu ändern.
Diese Methoden checken ebenfalls ob der User vorhanden ist und geben sonst eine `UserNotFoundException` aus.

## Endpunkte

+ @GetMapping (path = "status/{id}): der Status des Users mit der {id} wird ausgegeben
+ @PostMapping (path = "status/setOnline/{user}: der Status des Users wird auf Online gestellt
+ @PostMapping (path = "status/setOffline/{user}: der Status des Users wird auf Offline gestellt
