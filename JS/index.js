fetch('http://localhost:8081/api/fare/AI-840/DELHI/CHENNAI')
    .then(response => response.json())
    .then(fare => {
        console.log(fare);
    })