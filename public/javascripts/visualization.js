/**
 * Visualization of the Function dependency graph.
 */
var visualization = (function () {
  'use strict';

  var config = {
    width: 960,
    height: 500,
    node_radius: 20
  };

  /**
   * Converts supplied data into the format required for D3.
   */
  function asD3Graph(data) {
    var graph = {"nodes": data.nodes, "links": []};

    data.links.forEach(function(e) {
      var source = data.nodes.find(function(n) {
        return n.uuid === e.source;
      });

      var target = data.nodes.find(function(n) {
        return n.uuid === e.target;
      });

      graph.links.push({"source": source, "target": target});
    });

    return graph;
  }

  /**
   * Initialization logic
   */
  var init = {
    svg: function(cfg) {
      var svg = d3.select("#graph")
        .append("svg")
          .attr("width", cfg.width)
          .attr("height", cfg.height);

      svg.append("svg:defs").selectAll("marker")
        .data(["end"])
      .enter().append("svg:marker")
        .attr("id", String)
        .attr("viewBox", "0 -5 10 10")
        .attr("refX", 6 + cfg.node_radius)
        .attr("markerWidth", 6)
        .attr("markerHeight", 6)
        .attr("orient", "auto")
      .append("svg:path")
        .attr("d", "M0,-5L10,0L0,5Z");

      return svg;
    },

    force: function(graph, cfg) {
      return d3.layout.force()
        .charge(-120)
        .linkDistance(8 * cfg.node_radius)
        .gravity(0.01)
        .size([cfg.width, cfg.height])
        .nodes(graph.nodes)
        .links(graph.links);
    },

    link: function(graph, cfg, svg) {
      return svg
        .selectAll(".dependsOn")
          .data(graph.links)
        .enter().append("line")
          .attr("class", "dependsOn")
          .attr("marker-end", "url(#end)");
    },

    node: function(graph, cfg, svg, force) {
      var node = svg
        .selectAll(".function")
          .data(graph.nodes)
        .enter().append("g")
          .attr("class", "function")
          .call(force.drag);

      node.append("circle")
        .attr("r", cfg.node_radius)

      node.append("title")
        .text(function(d) { return d.description; });

      node.append("text")
        .attr("x", 1.2 * cfg.node_radius)
        .attr("dy", "0.4em")
        .text(function(d) { return d.description; });

      return node;
    }
  }; // init

  return {
    init: function(externalGraph) {
      var graph = asD3Graph(externalGraph)

      // Clear loading message
      d3.select("#graph").html("");

      // Inits
      var svg = init.svg(config);
      var force = init.force(graph, config);
      var link = init.link(graph, config, svg);
      var node = init.node(graph, config, svg, force);

      force.on("tick", function() {
        link
          .attr("x1", function(d) { return d.source.x; })
          .attr("y1", function(d) { return d.source.y; })
          .attr("x2", function(d) { return d.target.x; })
          .attr("y2", function(d) { return d.target.y; });

        node.attr("transform", function(d) {
    	    return "translate(" + d.x + "," + d.y + ")";
        });
      });

      force.start();
    }
  };
})();
