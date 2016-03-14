CREATE (n:Function {uuid: "bbb43cb2-5655-416c-9e48-886c2d38f5e0", description: "Add two integers"})
CREATE (n:Function {uuid: "ac80e134-407e-4582-8866-ab963c9dbe26", description: "Recognise an integer"})
CREATE (n:Function {uuid: "24cb7fe6-8544-4c62-8087-3ce05a4e2a07", description: "Describe ray-tracing"})
CREATE (n:Function {uuid: "1b1e0723-2244-44b9-b05b-7e4a0c23e7da", description: "Describe viewplane"})
CREATE (n:Function {uuid: "27ec5344-c901-4043-a704-2e0402b9677b", description: "Describe light reflection"})
CREATE (n:Function {uuid: "639aed93-9158-4a80-9fc3-ca122cd25faf", description: "Describe light refraction"})
CREATE (n:Function {uuid: "5ed92956-d6e2-401d-a1dd-2263eab95460", description: "Root"})

MATCH (s:Function), (t:Function)
WHERE s.description = "Add two integers" AND t.description = "Recognise an integer"
CREATE (s)-[:DEPENDS_ON]->(t)

MATCH (s:Function), (t:Function)
WHERE s.description = "Describe ray-tracing" AND t.description = "Describe viewplane"
CREATE (s)-[:DEPENDS_ON]->(t)

MATCH (s:Function), (t:Function)
WHERE s.description = "Describe ray-tracing" AND t.description = "Describe light reflection"
CREATE (s)-[:DEPENDS_ON]->(t)

MATCH (s:Function), (t:Function)
WHERE s.description = "Describe ray-tracing" AND t.description = "Describe light refraction"
CREATE (s)-[:DEPENDS_ON]->(t)

MATCH (s:Function), (t:Function)
WHERE s.description = "Describe viewplane" AND t.description = "Root"
CREATE (s)-[:DEPENDS_ON]->(t)

MATCH (s:Function), (t:Function)
WHERE s.description = "Describe light reflection" AND t.description = "Root"
CREATE (s)-[:DEPENDS_ON]->(t)

MATCH (s:Function), (t:Function)
WHERE s.description = "Describe light refraction" AND t.description = "Root"
CREATE (s)-[:DEPENDS_ON]->(t)

MATCH (s:Function), (t:Function)
WHERE s.description = "Recognise an integer" AND t.description = "Root"
CREATE (s)-[:DEPENDS_ON]->(t)

CREATE (n:Implementation {uuid: "f12e955e-e005-4f35-ae40-f354de94c261", title: "Using A Calculator To Add Integers", source:"The lazy approach. Just type ina  number, press +, type in another and press =."})
CREATE (n:Implementation {uuid: "93fba3be-046d-4c0c-b274-a4c6cc71f430", title: "Asking A Friend To Add Numbers", source:"Just ask a friend to do it. Warning: May result in loss of friendship if overused."})

MATCH (s:Implementation), (t:Function)
WHERE s.title = "Using A Calculator To Add Integers" AND t.description = "Add two integers"
CREATE (s)-[:IMPLEMENTS]->(t)

MATCH (s:Implementation), (t:Function)
WHERE s.title = "Asking A Friend To Add Numbers" AND t.description = "Add two integers"
CREATE (s)-[:IMPLEMENTS]->(t)
